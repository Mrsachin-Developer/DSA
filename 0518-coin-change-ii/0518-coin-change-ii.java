class Solution {
    public int solve(int target, int[] coins, int[][] dp) {

        for (int t = 0; t <= target; t++) {
            dp[0][t] = (t % coins[0] == 0) ? 1 : 0;
        }
        for (int i = 1; i < coins.length; i++) {
            for (int tar = 0; tar <= target; tar++) {
                int notpick = dp[i - 1][tar];
                int pick = 0;

                if (coins[i] <= tar) {
                    pick = dp[i][tar - coins[i]];
                }
                dp[i][tar] = pick + notpick;
            }
        }

        return dp[coins.length - 1][target];
    }

    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];

        return solve(amount, coins, dp);
    }
}