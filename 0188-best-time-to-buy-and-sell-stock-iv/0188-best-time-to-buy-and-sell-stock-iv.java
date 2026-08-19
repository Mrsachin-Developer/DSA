class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][] ahead = new int[2][k + 1];
        int[][] curr = new int[2][k + 1];

 

        for (int i = n - 1; i >= 0; i--) {
            for (int buy = 0; buy <= 1; buy++) {
                for (int cap = k; cap >= 1; cap--) {
                    if (buy == 1) {
                        int take = -prices[i] + ahead[0][cap];
                        int nottake =ahead[1][cap];

                     curr[buy][cap] = Math.max(take, nottake);
                    } else {
                        int sell = prices[i] + ahead[1][cap - 1];
                        int not = ahead[0][cap];

                       curr[buy][cap] = Math.max(sell, not);
                    }
                }
            }
            ahead=curr.clone();
        }
        return ahead[1][k];
    }
}