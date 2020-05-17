class Solution {
  public int minCost(int[][] costs) {
    int n = costs.length;
    if (n == 0) return 0;
    for (int i = 1; i < n; i++) {
      costs[i][0] = costs[i][0] + Math.min(costs[i - 1][1], costs[i - 1][2]);
      costs[i][1] = costs[i][1] + Math.min(costs[i - 1][0], costs[i - 1][2]);
      costs[i][2] = costs[i][2] + Math.min(costs[i - 1][0], costs[i - 1][1]);
    }
    return Math.min(costs[n - 1][0], Math.min(costs[n - 1][1], costs[n - 1][2]));
  }
}

/**
 * performance: 1 ms < 100%, 39 MB < 100%
 * time complexity: O(n)
 * space complexity: O(1)
 * notes: input is modified.
 */

class Solution {
  public int minCost(int[][] costs) {
    int n = costs.length;
    if (n == 0) return 0;
    int[][] dp = new int[2][3];
    dp[0] = costs[0];
    int j = 0;
    int k = 1;
    for (int i = 1; i < n; i++) {
      dp[k][0] = costs[i][0] + Math.min(dp[j][1], dp[j][2]);
      dp[k][1] = costs[i][1] + Math.min(dp[j][0], dp[j][2]);
      dp[k][2] = costs[i][2] + Math.min(dp[j][0], dp[j][1]);
      k = j;
      j = i & 1;
    }
    return Math.min(dp[j][0], Math.min(dp[j][1], dp[j][2]));
  }
}

/**
 * performance: 1 ms < 100%, 39 MB < 100%
 * time complexity: O(n)
 * space complexity: O(1)
 * notes: preserves the input.
 */
