class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int left=0;
        int right=k;

        int max=Integer.MIN_VALUE;

        int sum=0;

        for(int i=0;i<k;i++){
            sum+=nums[i];
        }
        max=sum;

        while(right<nums.length){
            sum+=nums[right];
            sum-=nums[left];

            max=Math.max(max,sum);
            left++;
            right++;
        }

        return (double)max/k;
    }
}