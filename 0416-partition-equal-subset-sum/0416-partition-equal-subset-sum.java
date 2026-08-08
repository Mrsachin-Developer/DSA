class Solution {

    public boolean solve(int index, int target, int[] nums, int[][] dp) {
        if (target == 0)
            return true;
        if (index == 0) {
            return nums[0] == target;
        }

        if (dp[index][target] != -1)
            return dp[index][target] == 1;
        boolean nottake = solve(index - 1, target, nums, dp);
        boolean take = false;

        if (target >= nums[index]) {
            take = solve(index - 1, target - nums[index], nums, dp);
        }

        dp[index][target] = (take) || (nottake) ? 1 : 0;
        return take || nottake;
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

        for (int[] rows : dp) {
            Arrays.fill(rows, -1);
        }
        return solve(n - 1, target, nums, dp);
    }
}