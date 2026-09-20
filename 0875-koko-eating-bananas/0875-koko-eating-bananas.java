class Solution {

    public int maxElement(int[] arr) {
        int maxi = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            maxi = Math.max(maxi, arr[i]);
        }
        return maxi;
    }

    public int TotalHours(int[] arr, int hours) {

        int n = arr.length;

        int total = 0;

        for (int i = 0; i < n; i++) {
            total += Math.ceil((double) (arr[i]) / (double) (hours));
        }
        return total;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;

        int high = maxElement(piles);

        int ans = Integer.MAX_VALUE;

        while (low <= high) {

            int mid = (low + high) / 2;

            int totalHr = TotalHours(piles, mid);

            if (totalHr <= h) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        // return low;
        return ans;
    }
}