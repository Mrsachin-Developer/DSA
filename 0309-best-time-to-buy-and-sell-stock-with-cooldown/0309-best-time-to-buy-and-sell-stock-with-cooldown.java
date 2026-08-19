class Solution {

    public int maxProfit(int[] prices) {
        int n = prices.length;

        int[][] dp = new int[n + 2][2];

        for (int i = n - 1; i >= 0; i--) {
            for (int buy = 1; buy >= 0; buy--) {
                if (buy == 1) {
                    int take = -prices[i] + dp[i + 1][0];
                    int nottake = dp[i + 1][1];
                    dp[i][buy] = Math.max(take, nottake);
                } else {
                    int sell = prices[i] + dp[i + 2][1];
                    int not = dp[i + 1][0];
                    dp[i][buy] = Math.max(sell, not);
                }
            }
        }
        return dp[0][1];
    }
}