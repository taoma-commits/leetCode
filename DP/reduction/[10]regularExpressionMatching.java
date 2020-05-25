class Solution {
  public boolean isMatch(String s, String p) {
    int m = s.length();
    int n = p.length();
    boolean[][] dp = new boolean[m + 1][n + 1];
    dp[0][0] = true;
    for (int i = 0; i < m + 1; i++) {
      for (int j = 1; j < n + 1; j++) {
        if (i > 0 && (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '.')) {
          dp[i][j] = dp[i - 1][j - 1];
        } else if (p.charAt(j - 1) == '*') {
          if (i > 0 && (p.charAt(j - 2) == s.charAt(i - 1) || p.charAt(j - 2) == '.')) {
            dp[i][j] = dp[i][j - 2] || dp[i - 1][j - 1] || dp[i - 1][j];
          } else {
            dp[i][j] = dp[i][j - 2];
          }
        } else {
          dp[i][j] = false;
        }
      }
    }
    return dp[m][n];
  }
}

/**
 * performance: 4 ms < 84%
 * time complexity: O((m + 1) * (n + 1))
 * space complexity: O((m + 1) * (n + 1))
 * notes: padding dp array; dp 1st row. 
 */
 
