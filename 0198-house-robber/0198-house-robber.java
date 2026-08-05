class Solution {

    public int recurr(int[] dp, int[] a) {
        int prev = a[0];

        int prev2 = 0;
        for (int i = 1; i < a.length; i++) {

            int take = a[i];
            if (i > 1) {
                take += prev2;
            }
            int nottake = 0 + prev;
            int curri = Math.max(take, nottake);
            prev2 = prev;
            prev = curri;
        }

        return prev;
    }

    public int rob(int[] nums) {
        int n = nums.length;

        int[] dp = new int[n];

        int result = recurr(dp, nums);
        return result;
    }
}