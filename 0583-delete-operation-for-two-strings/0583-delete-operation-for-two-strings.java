class Solution {

        public int solve(int[][] dp, String s1, String s2, int m, int n) {

        if (m == 0 || n == 0)
            return 0;

        for (int i = 1; i <= m; i++) {

            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }

        }
        return dp[m][n];
      
    }
    public int minDistance(String word1, String word2) {
          int m = word1.length();
        int n =word2.length() ;
   

        int[][] dp = new int[m + 1][n + 1];
       int lcs=solve(dp, word1, word2, m, n);

       int deletion = m-lcs;
       int addition= n-lcs;
       return deletion+addition;
    }
}