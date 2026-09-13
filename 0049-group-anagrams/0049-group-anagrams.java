class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();

        HashMap<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            String word = strs[i];
            char[] arr = word.toCharArray();
            Arrays.sort(arr);
            String signature = new String(arr);

            if (!map.containsKey(signature)) {
                map.put(signature, new ArrayList<>());
            }
            map.get(signature).add(word);

        }

        for (List<String> group : map.values()) {
            result.add(group);
        }
        return result;
    }
}