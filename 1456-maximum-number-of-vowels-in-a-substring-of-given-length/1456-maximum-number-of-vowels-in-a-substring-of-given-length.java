class Solution {

    public boolean isBoolean(char ch){
        return ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u';
    }
    public int maxVowels(String s, int k) {
        int left = 0;
        int count = 0;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < k; i++) {
            if (isBoolean(s.charAt(i))) {
                count++;
            }
        }
        max = count;
        int r = k;
        while (r < s.length()) {
            if (isBoolean(s.charAt(r))) {
                count++;
            }
            if (isBoolean(s.charAt(left))) {
                count--;
            }
            max=Math.max(max,count);
            r++;
            left++;
        }
        return max;
    }
}