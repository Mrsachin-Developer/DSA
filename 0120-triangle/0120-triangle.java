class Solution {

    public int solve(List<List<Integer>> mat, int[][] dp, int r, int c) {
        int n = mat.size();
        for (int j =0; j < n; j++) {
            dp[n - 1][j] = mat.get(n - 1).get(j);
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                int d = mat.get(i).get(j) + dp[i+1][j];
                int dg = mat.get(i).get(j) + dp[i+1][j+1];
                dp[i][j] = Math.min(d, dg);
            }
        }

        return dp[0][0];
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];

       
        return solve(triangle, dp, 0, 0);
    }
}