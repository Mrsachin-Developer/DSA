class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int l = 0;
        int r = k;
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            sum += nums[i];

        }
        max = sum;

        while (r < nums.length) {

            sum = sum + nums[r];
            sum = sum - nums[l];
            r++;
            l++;
            max = Math.max(max, sum);
        }

        return (double) max / k;

    }
}