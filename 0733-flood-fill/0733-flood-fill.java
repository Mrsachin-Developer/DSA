class Pair {
    int row;
    int col;

    Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        int initialColor = image[sr][sc];
        if (initialColor == color) {
            return image;
        }

        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair(sr, sc));
        image[sr][sc] = color;

        int[] drow = { -1, 0, 1, 0 };
        int[] dcol = { 0, 1, 0, -1 };

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            int r = curr.row;
            int c = curr.col;
            for (int i = 0; i < 4; i++) {
                int nrow = r + drow[i];
                int ncol = c + dcol[i];

                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m
                        && image[nrow][ncol] == initialColor) {
                    q.offer(new Pair(nrow, ncol));

                    image[nrow][ncol] = color;

                }
            }
        }
        return image;

    }
}