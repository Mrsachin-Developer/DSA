class Solution {
    public int solve(int r, int c,int[][]dp, int[][] grid) {

        if (r == 0 && c == 0) {
            return grid[0][0];
        }
        if (r < 0 || c < 0) {
            return Integer.MAX_VALUE;
        }
        if (dp[r][c] != -1)
            return dp[r][c];
        int up = solve(r - 1, c,dp, grid);
        if (up != Integer.MAX_VALUE)
            up += grid[r][c];

        int left = solve(r, c - 1,dp, grid);
        if (left != Integer.MAX_VALUE)
            left += grid[r][c];

        return dp[r][c] = Math.min(up, left);

    }

    public int minPathSum(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int[][] dp = new int[r][c];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return solve(r - 1, c - 1, dp, grid);
    }
}