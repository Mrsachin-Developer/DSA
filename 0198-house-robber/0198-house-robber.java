class Solution {

    public int recurr( int[] dp, int[] a) {
        dp[0] = a[0];

        int negative = 0;
        for (int i = 1; i < a.length; i++) {
            int pick = a[i];
            if (i > 1) {
                pick += dp[i - 2];
            }
            int notpick = 0 + dp[i - 1];
            dp[i] = Math.max(pick, notpick);
        }

        return dp[a.length-1];
    }

    public int rob(int[] nums) {
        int n = nums.length;

        int[] dp = new int[n];
    
        int result = recurr( dp, nums);
        return result;
    }
}