class Solution {
    public int solve(int index, int target, int[] coins,int[][] dp) {
        if (index == 0) {
            return (target % coins[index] == 0) ? 1 : 0;
        }
        if (dp[index][target] != -1) {
            return dp[index][target];
        }
        int notpick = solve(index - 1, target, coins, dp);
        int pick = 0;

        if (coins[index] <= target) {
            pick = solve(index, target - coins[index], coins, dp);
        }

        return dp[index][target] = pick + notpick;
    }

    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for (int[] rows : dp) {
            Arrays.fill(rows, -1);
        }
        return solve(n - 1, amount, coins, dp);
    }
}