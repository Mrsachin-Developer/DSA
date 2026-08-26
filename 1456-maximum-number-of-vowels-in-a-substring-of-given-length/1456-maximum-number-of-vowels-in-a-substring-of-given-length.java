class Solution {
    public boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public int maxVowels(String s, int k) {
        int l = 0;
        int count = 0;
        int max = 0;

        for (int i = 0; i < k; i++) {
            if (isVowel(s.charAt(i))) {
                count++;
            }
        }
        max = count;
        int r = k;

        while (r < s.length()) {
            if (isVowel(s.charAt(r))) {
                count++;
            }
            if (isVowel(s.charAt(l))) {
                count--;
            
            }
                l++;
            r++;
            max=Math.max(count,max);
        }
        return max;
    }
}