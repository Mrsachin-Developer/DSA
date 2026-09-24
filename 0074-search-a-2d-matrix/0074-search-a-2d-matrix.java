class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0)
            return false;
        int r = matrix.length;
        int c = matrix[0].length;

        int low = 0;
        int high = (r * c) - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int newR = mid / c;
            int newC = mid % c;

            if (matrix[newR][newC] < target) {
                low = mid + 1;
            } else if (matrix[newR][newC] > target) {
                high = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}