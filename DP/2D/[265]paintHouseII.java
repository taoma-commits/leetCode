class Solution {
  public int minCostII(int[][] costs) {
    int n = costs.length;
    if (n == 0) return 0;
    int k = costs[0].length;
    int[][] dp = new int[2][k];
    dp[0] = costs[0];
    int a = 0;
    int b = 1;
    for (int i = 1; i < n; i++) {
      int min1 = Integer.MAX_VALUE;
      int min2 = Integer.MAX_VALUE;
      int minIdx = 0;
      for (int j = 0; j < k; j++) {
        if (dp[a][j] < min1) {
          min2 = min1;
          min1 = dp[a][j];
          minIdx = j;
        } else {
          if (dp[a][j] < min2) min2 = dp[a][j];
        }
      }
      for (int j = 0; j < k; j++) {
        if (j == minIdx) {
          dp[b][j] = costs[i][j] + min2;
        } else {
          dp[b][j] = costs[i][j] + min1;
        }
      }
      b = a;
      a = i % 2;
    }
    int res = Integer.MAX_VALUE;
    for (int j = 0; j < k; j++) {
      res = Math.min(dp[a][j], res);
    }
    return res;
  }
}

/**
 * performance: 2 ms < 100%, 40 MB < 100%
 * time complexity: O(n * k)
 * space complexity: O(k)
 */
