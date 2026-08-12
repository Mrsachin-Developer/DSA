class Solution {

    public int solve(int index, int[] nums, int target) {
        if (index == 0) {
            if (target == 0 && nums[0] == 0)
                return 2;
            if (target == 0 || target == nums[0])
                return 1;
            return 0;
        }

     

        int notpick = solve(index - 1,nums, target);
        int pick = 0;
        if (nums[index] <= target) {
            pick = solve(index - 1,nums, target - nums[index]);
        }
        return pick + notpick;
    }

    public int findTargetSumWays(int[] nums, int target) {

        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }

        int t = (int) 1e9;
        if ((sum - target) < 0 || (sum - target) % 2 != 0)
            return 0;

         t = (sum - target) / 2;

        int ans = solve(n - 1, nums, t);

        if (ans >= (int) 1e9) {
            return 0;
        }
        return ans;
    }
}