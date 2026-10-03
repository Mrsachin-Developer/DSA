class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);// Sort by end time
        int n = intervals.length;
        int cnt = 1;
        int lastendtime = intervals[0][1];

        for (int i = 1; i < n; i++) {
            if (intervals[i][0] >= lastendtime) {
                lastendtime = intervals[i][1];
                cnt = cnt + 1;
            }
        }
        return n - cnt;
    }
}