class Solution {
  public int maximalSquare(char[][] matrix) {
    int m = matrix.length;
    if (m == 0) return 0;
    int n = matrix[0].length;
    if (n == 0) return 0;
    int max = 0;
    int[][] dp = new int[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (matrix[i][j] == '1') {
          if (i * j == 0) {
            dp[i][j] = 1;
          } else {
            dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
          }
          max = Math.max(max, dp[i][j]);
        }
      }
    }
    return max * max;
  }
}

/**
 * performance: 6 ms < 83%
 * time complexity: O(m * n)
 * space complexity: O(m * n)
 */
