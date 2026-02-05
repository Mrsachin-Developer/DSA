class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int tank = 0;
        int total = 0;
        int start = 0;

        for (int i = 0; i < n; i++) {
            int diff = gas[i] - cost[i];
            total += diff;
            tank += diff;

            if (tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }
        if (total >= 0) {
            return start;
        } else {
            return -1;
        }

    }
}