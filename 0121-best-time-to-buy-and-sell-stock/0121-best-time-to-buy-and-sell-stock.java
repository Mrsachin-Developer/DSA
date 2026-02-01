class Solution {
    public int maxProfit(int[] prices) {

      int max=0;
        int n= prices.length;

           int min=prices[0];
        for(int i=0;i<n;i++){
            if(prices[i]<min){
                min=prices[i];

            }
            int profit = prices[i]-min;
         max= Math.max(profit,max);
        }
        return max;
    }
}