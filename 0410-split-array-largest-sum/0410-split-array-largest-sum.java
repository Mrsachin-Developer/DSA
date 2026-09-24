class Solution {
    public int minRange(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (max < nums[i]) {
                max = nums[i];
            }
        }
        return max;
    }

    public int maxRange(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
        sum+=nums[i];
        }
        return sum;
    }

public boolean isPossible(int mid, int[] nums, int k) {

    int sum = 0;
    int subarrays = 1;

    for (int i = 0; i < nums.length; i++) {

        if (sum + nums[i] <= mid) {

            sum += nums[i];

        } else {

            subarrays++;
            sum = nums[i];
        }
    }

    return subarrays <= k;
}

    public int splitArray(int[] nums, int k) {
        int low = minRange(nums);
        int high = maxRange(nums);

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isPossible(mid, nums, k) == true) { // isPossible(mid) means can we separate the array in k subrray with sum mid
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}