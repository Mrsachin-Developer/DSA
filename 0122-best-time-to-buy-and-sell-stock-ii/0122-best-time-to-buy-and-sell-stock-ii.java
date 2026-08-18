class Solution {

    public int maxProfit(int[] prices) {

        int n = prices.length;

        int aheadBuy = 0;      // dp[index+1][1]
        int aheadNotBuy = 0;   // dp[index+1][0]

        for (int ind = n - 1; ind >= 0; ind--) {

            int currBuy = Math.max(
                    -prices[ind] + aheadNotBuy,
                    aheadBuy);

            int currSell = Math.max(
                    prices[ind] + aheadBuy,
                    aheadNotBuy);

            aheadBuy = currBuy;
            aheadNotBuy = currSell;
        }

        return aheadBuy;
    }
}