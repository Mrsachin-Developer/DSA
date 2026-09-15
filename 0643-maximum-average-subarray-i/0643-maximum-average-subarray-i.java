class Solution {
    public double findMaxAverage(int[] nums, int k) {

        int left = 0;
        int right = k;

        int n = nums.length;
        int max = 0;
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        max = sum;

        while (right < n) {
            sum += nums[right];
            sum -= nums[left];
            left++;
            right++;

            max=Math.max(max,sum);
        }
        return (double)max/k;
    }
}