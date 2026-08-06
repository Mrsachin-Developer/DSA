class Solution {
    public int solve(int r, int c, int[][] dp, int[][] mat) {

        dp[0][0] = 1;

        for (int i = 0; i <= r; i++) {
            int up = 0;
            int left = 0;
            for (int j = 0; j <= c; j++) {
                if (mat[i][j] == 1) {

                    dp[i][j] = 0;
                    continue;
                }

                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                    continue;

                }

                if (i > 0) {
                    up = dp[i - 1][j];
                }
                if (j > 0) {
                    left = dp[i][j - 1];
                }
                dp[i][j] = up + left;
            }
        }
        return dp[r][c];
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int r = obstacleGrid.length;
        int c = obstacleGrid[0].length;

        int[][] dp = new int[r][c];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(r - 1, c - 1, dp, obstacleGrid);
    }
}