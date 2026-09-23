class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int freq[] = new int[26];
        int[] windowfreq = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            char ch = s1.charAt(i);

            freq[ch - 'a']++;
        }
        int left = 0;

        for (int right = 0; right < s2.length(); right++) {

            char ch = s2.charAt(right);

            windowfreq[ch - 'a']++;

            while (right - left + 1 > s1.length()) {
                char leftch = s2.charAt(left);

                windowfreq[leftch - 'a']--;
                left++;
            }

            if (Arrays.equals(freq, windowfreq)) {
                return true;
            }

        }

        return false;
    }
}