class Solution {

    public int maxProfit(int[] prices) {

        int n = prices.length;
        int[][][] dp = new int[n + 1][2][3];
        for (int i = 0; i <= n; i++) {
            for (int buy = 0; buy <= 1; buy++) {
                dp[i][buy][0] = 0;
            }
        }
        for (int buy = 0; buy <= 1; buy++) {
            for (int c = 2; c >= 0; c--) {
                dp[n][buy][c] = 0;
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int buy = 0; buy <= 1; buy++) {
                for (int cap = 2; cap >= 1; cap--) {

                    if (buy == 1) {

                        int take = -prices[i]
                                + dp[i + 1][0][cap];

                        int notTake = dp[i + 1][1][cap];

                        dp[i][buy][cap] = Math.max(take, notTake);
                    }

                    else {

                        int sell = prices[i]
                                + dp[i + 1][1][cap - 1];

                        int notSell = dp[i + 1][0][cap];

                        dp[i][buy][cap] = Math.max(sell, notSell);
                    }
                }
            }
        }
        return dp[0][1][2];
    }
}