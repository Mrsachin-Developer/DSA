class Solution {

    public int solve(int[][] dp, String s1, String s2, int m, int n) {

        if (m == 0 || n == 0)
            return 0;

        for (int i = 1; i <= m; i++) {

            for (int j = 1; j <=n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] =1+ dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }

        }
     int lps=dp[m][n];
        return m-lps;
    }

    public int minInsertions(String s) {
        int m = s.length();
        int n = m;
        StringBuilder str = new StringBuilder(s);
        String s2 = str.reverse().toString();

        int[][] dp = new int[m + 1][n + 1];
        return solve(dp, s, s2, m, n);
    }
}