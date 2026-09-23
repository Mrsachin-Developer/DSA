class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        List<Integer> ans = new ArrayList<>();
        Deque<Integer> dq = new ArrayDeque<>();

        int left = 0;

        for (int right = 0; right < nums.length; right++) {

            // Remove smaller elements from back
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[right]) {
                dq.pollLast();
            }

            dq.offerLast(right);

            // Window size exceeded
            if (right - left + 1 > k) {

                // Remove expired index
                if (dq.peekFirst() == left) {
                    dq.pollFirst();
                }

                left++;
            }

            // Window of size k formed
            if (right - left + 1 == k) {
                ans.add(nums[dq.peekFirst()]);
            }
        }

        int[] result = new int[ans.size()];

        for (int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i);
        }

        return result;
    }
}