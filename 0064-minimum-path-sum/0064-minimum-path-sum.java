class Solution {
    public int solve(int r, int c, int[][] dp, int[][] grid) {

        for (int i = 0; i <= r; i++) {
            int up = (int) 1e9;
            int left = (int) 1e9;
            for (int j = 0; j <= c; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[0][0];
                    continue;
                }
                if (i > 0) {
                    up = grid[i][j] + dp[i - 1][j];

                }
                if (j > 0) {
                    left = grid[i][j] + dp[i][j - 1];
                }
                dp[i][j] = Math.min(up, left);
            }
        }
        return dp[r][c];
    }

    public int minPathSum(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int[][] dp = new int[r][c];

        return solve(r - 1, c - 1, dp, grid);
    }
}