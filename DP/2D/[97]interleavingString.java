class Solution {
  public boolean isInterleave(String s1, String s2, String s3) {
    int m = s1.length();
    int n = s2.length();
    if (m + n != s3.length()) return false;
    boolean[][] dp = new boolean[m + 1][n + 1];
    for (int i = 0; i < m + 1; i++) {
      for (int j = 0; j < n + 1; j++) {
        if (i == 0 && j == 0) {
          dp[i][j] = true;
        }
        if (i > 0) {
          dp[i][j] = dp[i][j] || (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1));
        }
        if (j > 0) {
          dp[i][j] = dp[i][j] || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
        }
      }
    }
    return dp[m][n];
  }
}

/**
 * performance: 5 ms < 60%
 * time complexity: O(m * n)
 * space complexity: O(m * n)
 */
