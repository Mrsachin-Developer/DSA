class Solution {
    public int solve(int n, int m, int[][] dp, String s1, String s2) {
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int j = 1; j <= m; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];

                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][m];

    }

    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n + 1][m + 1];

        return solve(n , m , dp, s, t);
    }
}