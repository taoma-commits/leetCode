class Solution {
  public int numDistinct(String s, String t) {
    char[] S = s.toCharArray();
    char[] T = t.toCharArray();
    int[][] dp = new int[T.length + 1][S.length + 1];
    Arrays.fill(dp[0], 1);
    for (int i = 1; i < T.length + 1; i++) {
      for (int j = i; j < S.length + 1; j++) {
        dp[i][j] = T[i - 1] == S[j - 1] ? dp[i - 1][j - 1] + dp[i][j - 1] : dp[i][j - 1];
      }
    }
    return dp[T.length][S.length];
  }
}

/**
 * performance: 4 ms < 96%, 39 MB < 12.5% 
 * notes: 2-dim dp; first row and column for empty string
 */
