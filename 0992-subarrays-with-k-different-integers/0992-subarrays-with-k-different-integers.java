class Solution {

    public int atmost(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int left = 0;
        int count = 0;
        for (int right = 0; right < n; right++) {

            map.put(nums[right],
                    map.getOrDefault(nums[right], 0) + 1);

            while (map.size() > k) {

                map.put(nums[left],
                        map.get(nums[left]) - 1);

                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }

                left++;
            }
            count += right - left + 1;
        }
        return count;
    }

    public int subarraysWithKDistinct(int[] nums, int k) {
        int atmostK = atmost(nums, k);
        int atmostK1 = atmost(nums, k - 1);

        return atmostK - atmostK1;
    }
}