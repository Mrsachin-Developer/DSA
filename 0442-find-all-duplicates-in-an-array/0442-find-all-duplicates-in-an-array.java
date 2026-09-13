class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int currentVal = Math.abs(nums[i]);
            int shouldAt = currentVal - 1;

            if (nums[shouldAt] < 0) {
                ans.add(currentVal);
            } else {
                nums[shouldAt] = -nums[shouldAt];
            }

        }
        return ans;
    }
}