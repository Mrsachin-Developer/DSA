class Solution {
    public int maxProfit(int[] prices) {
        int n= prices.length;
int p=0;
int m=0;
        for(int i=1;i<n;i++){
            p=prices[i]-prices[i-1];
            if(p>0){
                m=m+p;
            }
        }
        return m;
    }
}