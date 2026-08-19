class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n+1][2][k+1];

        for (int buy = 0; buy <= 1; buy++) {
            for (int cap = k; cap >= 0; cap--) {
                dp[n][buy][cap] = 0;
            }
        }
        for (int i = 0; i <= n; i++) {
            for (int buy = 0; buy <= 1; buy++) {
                dp[i][buy][0] = 0;
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int buy = 0; buy <= 1; buy++) {
                for (int cap = k; cap >= 1; cap--) {
                    if (buy == 1) {
                        int take = -prices[i] + dp[i + 1][0][cap];
                        int nottake = dp[i + 1][1][cap];

                        dp[i][buy][cap] = Math.max(take, nottake);
                    } else {
                        int sell = prices[i] + dp[i + 1][1][cap - 1];
                        int not = dp[i + 1][0][cap];

                        dp[i][buy][cap] = Math.max(sell, not);
                    }
                }
            }
        }
        return dp[0][1][k];
    }
}