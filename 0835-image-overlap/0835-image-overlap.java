class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        List<int[]> ones1 = new ArrayList<>();
        List<int[]> ones2 = new ArrayList<>();

        int n = img1.length;

        // Store coordinates of all 1s in img1
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (img1[r][c] == 1) {
                    ones1.add(new int[]{r, c});
                }
            }
        }

        // Store coordinates of all 1s in img2
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (img2[r][c] == 1) {
                    ones2.add(new int[]{r, c});
                }
            }
        }

        Map<String, Integer> map = new HashMap<>();
        int ans = 0;

        for (int[] p1 : ones1) {
            for (int[] p2 : ones2) {

                int dx = p2[0] - p1[0];
                int dy = p2[1] - p1[1];

                String key = dx + "," + dy;

                int freq = map.getOrDefault(key, 0) + 1;
                map.put(key, freq);

                ans = Math.max(ans, freq);
            }
        }

        return ans;
    }
}