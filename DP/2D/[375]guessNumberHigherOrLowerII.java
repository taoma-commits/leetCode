class Solution {
  public int getMoneyAmount(int n) {
    int[][] dp = new int[n + 1][n + 1];
    for (int j = 1; j < n; j++) {
      for (int i = 1; i < n + 1 - j; i++) {
        int min = Integer.MAX_VALUE;
        for (int k = i + j / 2; k < i + j; k++) {
          min = Math.min(min, k + Math.max(dp[i][k - 1], dp[k + 1][i + j]));
        }
        dp[i][i + j] = min;
      }
    }
    return dp[1][n];
  }
}

/**
 * performance: 6 ms < 95%
 * time complexity: O(n^3)
 * space complexity: O(n^2)
 * notes: optimize by setting k = i + j / 2; ignores k = i + j. 
 */
