class Solution {
  public int calculateMinimumHP(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;
    int[][] dp = new int[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (i == 0 && j == 0) {
          dp[m - 1][n - 1] = Math.max(1, - grid[m - 1][n - 1] + 1);
        } else if (i == 0 && j > 0) {
          dp[m - 1 - i][n - 1 - j] = Math.max(1, dp[m - 1 - i][n - j] - grid[m - 1 - i][n - 1 - j]);
        } else if (j == 0 && i > 0) {
          dp[m - 1 - i][n - 1 - j] = Math.max(1, dp[m - i][n - 1 - j] - grid[m - 1 - i][n - 1 - j]);
        } else {
          dp[m - 1 - i][n - 1 - j] = Math.max(1, Math.min(dp[m - i][n - 1 - j], dp[m - 1 - i][n - j]) - grid[m - 1 - i][n - 1 - j]);
        }
      }
    }
    return dp[0][0];
  }
}

/**
 * performance: 3 ms < 41%
 * time complexity: O(m * n)
 * space complexity: O(m * n)
 */
