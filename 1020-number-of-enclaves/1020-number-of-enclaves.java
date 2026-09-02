class Pair {
    int first;
    int second;

    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public int numEnclaves(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;
        int[][] visit = new int[n][m];
        Queue<Pair> q = new LinkedList<>();

        /// first row and last row
        for (int j = 0; j < m; j++) {

            if (grid[0][j] == 1 && visit[0][j] == 0) {
                q.add(new Pair(0, j));
                visit[0][j] = 1;
            }

            if (grid[n - 1][j] == 1 && visit[n - 1][j] == 0) {
                q.add(new Pair(n - 1, j));
                visit[n - 1][j] = 1;
            }
        }

        /// first col and last col
        for (int i = 0; i < n; i++) {
            if (grid[i][0] == 1 && visit[i][0] == 0) {
                q.add(new Pair(i, 0));
                visit[i][0] = 1;

            }
            if (grid[i][m - 1] == 1 && visit[i][m - 1] == 0) {
                q.add(new Pair(i, m - 1));
                visit[i][m - 1] = 1;

            }
        }

        int[] drow = { -1, 0, 1, 0 };
        int[] dcol = { 0, 1, 0, -1 };

        while (!q.isEmpty()) {
            int r = q.peek().first;
            int c = q.peek().second;
            q.remove();

            for (int i = 0; i < 4; i++) {
                int nrow = r + drow[i];
                int ncol = c + dcol[i];

                if (nrow < n && nrow >= 0 && ncol < m && ncol >= 0 && visit[nrow][ncol] == 0 && grid[nrow][ncol] == 1) {
                    q.add(new Pair(nrow, ncol));
                    visit[nrow][ncol] = 1;
                }
            }
        }
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && visit[i][j] == 0) {
                    cnt++;
                }
            }
        }
        return cnt;

    }
}