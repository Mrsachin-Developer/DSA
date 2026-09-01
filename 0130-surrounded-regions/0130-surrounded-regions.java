class Solution {

    public void dfs(int row, int col, int[][] visited, char[][] board) {
        int n = board.length;
        int m = board[0].length;
        int[] drow = { -1, 0, 1, 0 };
        int[] dcol = { 0, 1, 0, -1 };

        visited[row][col] = 1;

        for (int i = 0; i < 4; i++) {
            int nrow = row + drow[i];
            int ncol = col + dcol[i];

            if (nrow >= 0 && nrow < n && ncol < m && ncol >= 0 && board[nrow][ncol] == 'O'
                    && visited[nrow][ncol] == 0) {
                dfs(nrow, ncol, visited, board);
            }
        }

    }

    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        int[][] visited = new int[n][m];

        for (int j = 0; j < m; j++) {
            //  1st row
            if (board[0][j] == 'O' && visited[0][j] == 0) {
                dfs(0, j, visited, board);

            }
            // last row

            if (board[n - 1][j] == 'O' && visited[n - 1][j] == 0) {
                dfs(n - 1, j, visited, board);
            }
        }

        for (int i = 0; i < n; i++) {
            //  1st col
            if (board[i][0] == 'O' && visited[i][0] == 0) {
                dfs(i, 0, visited, board);

            }
            // last col
            if (board[i][m - 1] == 'O' && visited[i][m - 1] == 0) {
                dfs(i, m - 1, visited, board);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] == 0 && board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }

    }
}