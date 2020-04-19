

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
        if (total < 0) {
            return -1;
        } else {
            return start;
        }
    }
}

/**
 * performance: 0 ms < 100.00%, 38.7 MB < 21.57%.
 * time complexity: O(n)
 * space complexity: O(1)
 */
