class Solution {
    public int recurr(int[] a) {
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
        if(n==1) return nums[0];
        int[] arr1 = new int[n - 1];
        int[] arr2 = new int[n - 1];
        int j = 0;
        for (int i = 1; i < n; i++) {
            arr1[j++] = nums[i];
        }

        j = 0;
        for (int i = 0; i < n - 1; i++) {
            arr2[j++] = nums[i];
        }

     return Math.max(recurr(arr1), recurr(arr2));

    }
}