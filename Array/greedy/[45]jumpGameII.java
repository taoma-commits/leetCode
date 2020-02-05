/*
This is essentially finding shortest path on graph.
All the solutions are variations of Dijkstra's algorithm.
In the first solution, each time the end is met, all the
neighbors of previous nodes are visited. 
*/

class Solution {
    public int jump(int[] nums) {
        int end = 0, reach = 0, steps = 0;
        for (int i = 0; i < nums.length - 1; i++) { // note 2
            reach = Math.max(nums[i] + i, reach);
            if (i == end) {
                end = reach;
                reach = 0;
                steps++;
            }
        }
        return steps;
    }
}

/*
* performance: 2 ms < 95%, 37.7 MB < 77%.
* notes:
      1. greedy algorithm finds the global optimum: from one widest step to the next one includes
        all other possibilities.
      2. i < nums.length - 1 avoids comparison end = Math.max(reach, nums.length - 1) and the algorithm
        returns steps not steps - 1. As a consequence, the algorithm is 1 ms faster.
      3. time complexity = O(n), space complexity = O(1).
* companies: Amazon, Facebook, Google.
*/

class Solution {
    public int jump(int[] nums) {
        int curr = nums.length - 1;
        int steps = 0;
        while (curr > 0) {
            for (int j = 0; j < curr; j++) {
                if (nums[j] + j >= curr) {
                    curr = j;
                    steps++;
                    break;
                }
            }
        }
        return steps;
    }
}

/*
* performance: 128 ms, 35 MB.
* notes:
      1. same idea, algorithm runs backwards.
      2. time complexity: O(n^2), worst secenario [1, 1, 1, 1, 1].
*/

class Solution {
    public int jump(int[] nums) {
        int len = nums.length;
        int[] memo = new int[len];
        memo[0] = 0;
        for (int i = 1; i < len; i++) {
            memo[i] = Integer.MAX_VALUE;
        }
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (memo[j] != Integer.MAX_VALUE && nums[j] + j >= i) {
                    memo[i] = Math.min(memo[i], memo[j] + 1);
                }
            }
        }
        return memo[len - 1];
    }
}
/* performance: exceeds time limit
* notes: DP solution
*/
