class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] freqMap = new int[26];
        int[] windowFreq = new int[26];
        List<Integer> ans = new ArrayList<>();
        int k = p.length();
        int left = 0;

        for (int i = 0; i < p.length(); i++) {
            freqMap[p.charAt(i) - 'a']++;
        }

        for (int r = 0; r < s.length(); r++) {
            windowFreq[s.charAt(r) - 'a']++;

            if (r - left + 1 > k) {
                windowFreq[s.charAt(left) - 'a']--;
                left++;
            }

            if (r - left + 1 == k) {
                boolean same = true;
                for (int i = 0; i < 26; i++) {
                    if (freqMap[i] != windowFreq[i]) {
                        same = false;
                        break;

                    }

                }
                if (same) {
                    ans.add(left);
                }
            }
        }
        return ans;
    }
}