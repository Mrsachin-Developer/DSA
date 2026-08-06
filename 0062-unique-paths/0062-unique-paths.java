class Solution {

    public int solve(int i, int j, int[][] dp) {

        dp[0][0] = 1;

        for (int row = 0; row <= i; row++) {
            int up = 0;
            int left = 0;
            for (int col = 0; col <= j; col++) {
                if (row == 0 && col == 0) {
                    dp[row][col] = 1;
                    continue;
                }

                if (row > 0) {

                    up = dp[row - 1][col];
                }
                if (col > 0) {

                    left = dp[row][col - 1];
                }
                dp[row][col] = up + left;
            }
        }

        return dp[i][j];
    }

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        return solve(m - 1, n - 1, dp);
    }
}