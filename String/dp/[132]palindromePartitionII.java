class Solution {
  public int minCut(String s) {
    int n = s.length();
    boolean[][] isPalindrome = new boolean[n][n];
    for (int i = n - 1; i >= 0; i--) {
      for (int j = i; j < n; j++) {
        if ((j - i < 2 || isPalindrome[i + 1][j - 1]) && s.charAt(i) == s.charAt(j)) {
          isPalindrome[i][j] = true;
        }
      }
    }

    int[] dp = new int[n + 1];
    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[0] = -1;
    for (int j = 0; j < n; j++) {
      for (int i = 0; i <= j; i++) {
        if (isPalindrome[i][j]) {
          dp[j + 1] = Math.min(dp[j + 1], dp[i] + 1);
        }
      }
    }
    return dp[n];
  }
}

/**
 * performance: 10 ms < 85%, 39 MB < 12.5%
 * notes: double dp.
 */
