class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int low = 1;
        int high = n - 2;

        if (n == 1)
            return 0;
        if (nums[0] > nums[1])
            return 0;
        if (nums[n - 1] > nums[n - 2])
            return n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            // case1:mid is the peak
            if (nums[mid - 1] < nums[mid] && nums[mid + 1] < nums[mid]) {
                return mid;
            }
            // case2 : peak is on the right
            if (nums[mid] > nums[mid - 1]) {
                low = mid + 1;
            }
            //case3:Peak is on the left
            else {
                high = mid - 1;
            }

        }
        return -1;

    }
}