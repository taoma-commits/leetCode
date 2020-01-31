/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Gas Station.
Memory Usage: 38.7 MB, less than 21.57% of Java online submissions for Gas Station.
*/

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0, start = 0, sum = 0;
        for (int i = 0; i < gas.length; i++) {
            sum += gas[i] - cost[i];
            total += gas[i] - cost[i];
            if (sum < 0) {
                sum = 0;
                start = i + 1;
            }
        }
        if (total < 0) return -1;
        else return start;
    }
}

// tag: greedy
// idea: realize that total sum >= 0 guarantees existence of a solution.
