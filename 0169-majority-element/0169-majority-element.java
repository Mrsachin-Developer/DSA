class Solution {
    public int majorityElement(int[] nums) {
        int cnt = 1;

        int el = nums[0];

        int n = nums.length;
        for (int i = 1; i < n; i++) {
            if (nums[i] == el) {
                cnt++;
            } else {
                cnt--;
            }
            if (cnt == 0) {
                el = nums[i];
                cnt=1;

            }
        }
        return el;
    }
}