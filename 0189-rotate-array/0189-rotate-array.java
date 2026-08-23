class Solution {

    public void reverse(int[] n, int start, int end) {
        while (start < end) {
            int temp = n[start];
            n[start] = n[end];
            n[end] = temp;
            start++;
            end--;
        }

    }

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % nums.length;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k-1);
        reverse(nums, k, n - 1);
    }
}