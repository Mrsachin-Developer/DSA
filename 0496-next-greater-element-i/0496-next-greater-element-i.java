class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums2.length;
        Map<Integer, Integer> NGE = new HashMap<>();
        //here we are using Map because we know it stores value in key pair
        //and here num1 is a subset of num2 means if we find the nge of num2 we can iterate through the map of num2 to get the vlaues of num1 as it is subset means all the values of num1 will exist in num2 

        Stack<Integer> st = new Stack();

        for (int i = n - 1; i >= 0; i--) {
            int current = nums2[i];

            while (!st.isEmpty() && st.peek() <= current) {
                st.pop();
            }

            if (st.isEmpty()) {
                NGE.put(current, -1);
            } else {
                NGE.put(current, st.peek());
            }
            st.push(current);
        }
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = NGE.get(nums1[i]);
        }

        return result;
    }

}