class Solution {
    public int maxProfit(int[] prices) {
        int profit=0;
        int minprice=Integer.MAX_VALUE;
        int maxProfit=Integer.MIN_VALUE;

        for(int i=0;i<prices.length;i++){

minprice=Math.min(minprice,prices[i]);

profit=prices[i]-minprice;
maxProfit=Math.max(maxProfit,profit);


        }
        return maxProfit;
    }
}