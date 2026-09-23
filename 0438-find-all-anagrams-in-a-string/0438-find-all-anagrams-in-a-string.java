class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int[] freq = new int[26];

        int[] windowfreq = new int[26];

        for (int i = 0; i < p.length(); i++) {
            char ch = p.charAt(i);
            freq[ch - 'a']++;
        }

        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char leftchar = s.charAt(right);
            windowfreq[leftchar - 'a']++;

            while (right - left + 1 > p.length()) {
                windowfreq[s.charAt(left) - 'a']--;
                left++;
            }
            if (Arrays.equals(freq, windowfreq)) {
                ans.add(left);
            }
        }
        return ans;
    }
}