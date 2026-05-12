class Solution {

    public void dfs(int ro, int col, int[][] vist, char[][] board) {

        vist[ro][col] = 1;

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        int n = board.length;
        int m = board[0].length;

        for (int i = 0; i < 4; i++) {

            int nrow = ro + delRow[i];
            int ncol = col + delCol[i];

            if (nrow >= 0 && nrow < n &&
                ncol >= 0 && ncol < m &&
                vist[nrow][ncol] == 0 &&
                board[nrow][ncol] == 'O') {

                dfs(nrow, ncol, vist, board);
            }
        }
    }

    public void solve(char[][] board) {

        int n = board.length;
        int m = board[0].length;

        int[][] vist = new int[n][m];

        // Top and Bottom Row
        for (int j = 0; j < m; j++) {

            if (board[0][j] == 'O' && vist[0][j] == 0) {
                dfs(0, j, vist, board);
            }

            if (board[n - 1][j] == 'O' && vist[n - 1][j] == 0) {
                dfs(n - 1, j, vist, board);
            }
        }

        // Left and Right Column
        for (int i = 0; i < n; i++) {

            if (board[i][0] == 'O' && vist[i][0] == 0) {
                dfs(i, 0, vist, board);
            }

            if (board[i][m - 1] == 'O' && vist[i][m - 1] == 0) {
                dfs(i, m - 1, vist, board);
            }
        }

        // Flip unvisited O to X
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (board[i][j] == 'O' && vist[i][j] == 0) {
                    board[i][j] = 'X';
                }
            }
        }
    }
}