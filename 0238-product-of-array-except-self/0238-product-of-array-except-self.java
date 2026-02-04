class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        int leftp = 1;
        for(int i = 0; i < n; i++) {
            result[i] = leftp;
            leftp = leftp * nums[i];
        }

        int rightp = 1;
        for(int i = n - 1; i >= 0; i--) {
            result[i] = result[i] * rightp;
            rightp = rightp * nums[i];
        }

        return result;
    }
}
