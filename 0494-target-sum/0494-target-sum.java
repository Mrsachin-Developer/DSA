class Solution {

    public int solve(int[] nums, int t) {

        int n = nums.length;

        int[][] dp = new int[n][t + 1];

    
        if (nums[0] == 0)
            dp[0][0] = 2;
        else
            dp[0][0] = 1;

        if (nums[0] != 0 && nums[0] <= t)
            dp[0][nums[0]] = 1;

        for (int i = 1; i < n; i++) {

            for (int target = 0; target <= t; target++) {

                int notpick = dp[i - 1][target];

                int pick = 0;

                if (nums[i] <= target) {
                    pick = dp[i - 1][target - nums[i]];
                }

                dp[i][target] = pick + notpick;
            }
        }

        return dp[n - 1][t];
    }

    public int findTargetSumWays(int[] nums, int target) {

        int n = nums.length;

        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }

        if ((sum - target) < 0 || (sum - target) % 2 != 0)
            return 0;

        int t = (sum - target) / 2;

        return solve(nums, t);
    }
}