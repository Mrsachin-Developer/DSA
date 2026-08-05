class Solution {

    public int recurr(int index, int[] dp, int[] a) {
        if (index == 0)
            return a[index];
        if (index < 0)
            return 0;
        if (dp[index] != -1)
            return dp[index];
        int pick = a[index] + recurr(index - 2, dp, a);
        int notpick = 0 + recurr(index - 1, dp, a);

        return dp[index]=Math.max(pick, notpick);
    }

    public int rob(int[] nums) {
        int n = nums.length;

        int[] dp = new int[n];
        Arrays.fill(dp, -1);
      int result=  recurr(n - 1, dp, nums);
      return result;
    }
}