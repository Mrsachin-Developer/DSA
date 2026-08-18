class Solution {

    public int solve(int[][] dp,
                     int index,
                     int buy,
                     int n,
                     int[] prices) {

        if(index == n)
            return 0;

        if(dp[index][buy] != -1)
            return dp[index][buy];

        if(buy == 1){

            int take =
                -prices[index]
                + solve(dp,index+1,0,n,prices);

            int notTake =
                solve(dp,index+1,1,n,prices);

            return dp[index][buy]
                = Math.max(take,notTake);
        }

        else{

            int sell =
                prices[index]
                + solve(dp,index+1,1,n,prices);

            int notSell =
                solve(dp,index+1,0,n,prices);

            return dp[index][buy]
                = Math.max(sell,notSell);
        }
    }

    public int maxProfit(int[] prices) {

        int n = prices.length;

        int[][] dp = new int[n][2];

        for(int[] row: dp)
            Arrays.fill(row,-1);

        return solve(dp,0,1,n,prices);
    }
}