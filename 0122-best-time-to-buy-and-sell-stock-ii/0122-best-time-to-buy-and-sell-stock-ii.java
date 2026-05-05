class Solution {
    public int maxProfit(int[] prices) {
        int lastprice = prices[0];
        int totalProfit = 0;
        for (int i = 1; i < prices.length; i++) {

            int profit = prices[i] - lastprice;

            if (profit > 0) {
                totalProfit += profit;
            }
            lastprice = prices[i];

        }
        return totalProfit;
    }
}