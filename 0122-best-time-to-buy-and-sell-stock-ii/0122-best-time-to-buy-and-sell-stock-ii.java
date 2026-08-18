class Solution {

    public int maxProfit(int[] prices) {

        int n = prices.length;

        int[] ahead = new int[2];
        int[] cur = new int[2];

        ahead[0] = ahead[1] = 0;

        for (int ind = n - 1; ind >= 0; ind--) {

            for (int buy = 0; buy <= 1; buy++) {

                int profit;

                if (buy == 1) {

                    // Buy state
                    profit = Math.max(
                            -prices[ind] + ahead[0],
                            0 + ahead[1]);

                } else {

                    // Sell state
                    profit = Math.max(
                            prices[ind] + ahead[1],
                            0 + ahead[0]);
                }

                cur[buy] = profit;
            }

            ahead = cur.clone();
        }

        return ahead[1];
    }
}