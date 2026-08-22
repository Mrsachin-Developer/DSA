class Solution {

    public int maxProfit(int[] prices) {

        int n = prices.length;
        int[][] after = new int[2][3];
        int[][] curr = new int[2][3];

        for (int i = n - 1; i >= 0; i--) {
            for (int buy = 0; buy <= 1; buy++) {
                for (int cap = 2; cap >= 1; cap--) {

                    if (buy == 1) {

                        int take = -prices[i]
                                + after[0][cap];
                        int notTake = after[1][cap];

                        curr[buy][cap] = Math.max(take, notTake);
                    }

                    else {

                        int sell = prices[i]
                                + after[1][cap - 1];

                        int notSell = after[0][cap];

                        curr[buy][cap] = Math.max(sell, notSell);
                    }
                }
            }
            after = curr.clone();
        }
        return after[1][2];
    }
}