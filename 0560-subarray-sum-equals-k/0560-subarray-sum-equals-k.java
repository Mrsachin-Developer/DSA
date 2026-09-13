class Solution {

    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int currentPrefixsum = 0;
        int cnt = 0;
        map.put(0, 1);
        for (int i = 0; i < n; i++) {
            currentPrefixsum += nums[i];
            int prevPrefix = currentPrefixsum - k;
            if (map.containsKey(prevPrefix)) {
                cnt += map.get(prevPrefix);
            }
            map.put(currentPrefixsum, map.getOrDefault(currentPrefixsum, 0) + 1);

        }
        return cnt;
    }
}