class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int zeros = 0;

        int maxLen = 0;
        for (int r = 0; r < nums.length; r++) {

            if (nums[r] == 0) {
                zeros++;
            }
            while (zeros > k) {
                if (nums[left] == 0) {
                    zeros--;
                    left++;
                } else if (nums[left] == 1) {
                    left++;
                }

            }

            maxLen = Math.max(maxLen, r - left + 1);
        }
        return maxLen;
    }
}