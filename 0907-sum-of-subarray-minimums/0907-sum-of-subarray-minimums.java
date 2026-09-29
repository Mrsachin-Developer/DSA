import java.util.*;

class Solution {

    // Find Next Smaller Element (to the right)
    public int[] findNSE(int[] arr) {
        int n = arr.length;
        int[] nse = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            nse[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return nse;
    }

    // Find Previous Smaller Element (to the left)
    public int[] findPSE(int[] arr) {
        int n = arr.length;
        int[] pse = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }
            pse[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return pse;
    }

    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int[] nse = findNSE(arr);
        int[] pse = findPSE(arr);

        long total = 0;
        int MOD = (int) 1e9 + 7;

        for (int i = 0; i < n; i++) {
            long left = i - pse[i];
            long right = nse[i] - i;
            total = (total + (left * right % MOD) * arr[i]) % MOD;
        }

        return (int) total;
    }
}
