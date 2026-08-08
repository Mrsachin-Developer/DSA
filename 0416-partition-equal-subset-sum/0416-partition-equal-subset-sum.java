class Solution {

    public boolean solve(int index, int target, int[] nums, int[][] dp) {
        dp[0][0] = 1;

        for (int i = 0; i < nums.length; i++) {
            dp[i][0] = 1;
        }
        if (nums[0] <= target) {
            dp[0][nums[0]] = 1;
        }
        int n=nums.length;

        for (int i = 1; i < n; i++) {

            for (int t = 1; t <= target; t++) {

                int nottake = dp[i - 1][t];

                int take = 0;

                if (t >= nums[i]) {
                    take = dp[i - 1][t - nums[i]];
                }

                dp[i][t] = (take == 1 || nottake == 1) ? 1 : 0;
            }
        }

        return dp[n - 1][target] == 1;
    }

    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int tsum = 0;

        for (int i = 0; i < n; i++) {
            tsum = tsum + nums[i];
        }
        if (tsum % 2 != 0) {
            return false;
        }
        int target = tsum / 2;
        int[][] dp = new int[n][target + 1];

        return solve(n - 1, target, nums, dp);
    }
}