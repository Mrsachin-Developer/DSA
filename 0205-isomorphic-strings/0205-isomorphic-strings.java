class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Character> map = new HashMap<>();

        HashSet<Character> set = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            if (!map.containsKey(sc)) {
                if (set.contains(tc)) {
                    return false;
                }
                map.put(sc, tc);
                set.add(tc);
            } else {
                char expected = map.get(sc);

                if (expected != tc) {
                    return false;
                }

            }

        }
        return true;
    }

}