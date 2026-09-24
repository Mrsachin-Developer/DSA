class Solution {
    private int firstNegative(int[] row) {

        int low = 0;
        int high = row.length - 1;
        int ans = row.length;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (row[mid] < 0) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
            return ans;
    }

    public int countNegatives(int[][] grid) {
        int count = 0;
        int n = grid[0].length;

        for (int[] row : grid) {
            int idx = firstNegative(row);

            count += n - idx;
        }
        return count;
    }
}