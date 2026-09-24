class Solution {
    public int minRange(int[] weights) {
        int max = weights[0];

        for (int i = 1; i < weights.length; i++) {
            if (max < weights[i]) {
                max = weights[i];
            }

        }
        return max;
    }

    public int maxRange(int[] weights) {
        int n = weights.length;

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += weights[i];
        }

        return sum;
    }

    public boolean isPossible(int capacity, int[] weights, int days) {

        int currentLoad = 0;
        int daysNeeded = 1;

        for (int i = 0; i < weights.length; i++) {

            if (currentLoad + weights[i] <= capacity) {

                currentLoad += weights[i];

            } else {

                daysNeeded++;
                currentLoad = weights[i];
            }
        }

        return daysNeeded <= days;
    }

    public int shipWithinDays(int[] weights, int days) {
        int low = minRange(weights);
        int high = maxRange(weights);

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isPossible(mid, weights, days) == true) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}