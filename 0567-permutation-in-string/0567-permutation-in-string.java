class Solution {
    public boolean checkInclusion(String s1, String s2) {

        int k = s1.length();

        if (k > s2.length()) {
            return false;
        }

        int[] freqMap = new int[26];
        int[] windowFreq = new int[26];

        for (int i = 0; i < k; i++) {
            freqMap[s1.charAt(i) - 'a']++;
        }

        int left = 0;

        for (int right = 0; right < s2.length(); right++) {

            windowFreq[s2.charAt(right) - 'a']++;

       
            if (right - left + 1 > k) {
                windowFreq[s2.charAt(left) - 'a']--;
                left++;
            }

            if (right - left + 1 == k) {

                boolean same = true;

                for (int i = 0; i < 26; i++) {
                    if (freqMap[i] != windowFreq[i]) {
                        same = false;
                        break;
                    }
                }

                if (same) {
                    return true;
                }
            }
        }

        return false;
    }
}