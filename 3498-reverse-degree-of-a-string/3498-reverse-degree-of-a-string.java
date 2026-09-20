class Solution {
    public int reverseDegree(String s) {
        int n = s.length();
        int sum = 0;
        for(int i = 0; i <= n-1; i++){
            char ch = s.charAt(i);
            int value = 26 - (ch - 'a');
            sum = sum + value*(i+1);
        }
        return sum;
    }
}