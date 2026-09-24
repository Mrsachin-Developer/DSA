class Solution {

    public int highesSpeed(int[] piles) {
        int max = piles[0];
        for (int i = 1; i < piles.length; i++) {
            if (max < piles[i]) {
                max = piles[i];
            }
        }
        return max;
    }

    public boolean isPossible(int[] piles, int h, int speed) {
        long hours = 0;

        for (int pile : piles) {
            hours += (pile + speed - 1) / speed;
        }

        return hours <= h;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = highesSpeed(piles);

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isPossible(piles, h, mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}