class Solution {
  int[] dp;
  public int numSquares(int n) {
    dp = new int[n + 1];
    return dfs(n);
  }
  private int dfs(int n) {
    if (n == 0) return 0;
    int count = Integer.MAX_VALUE;
    for (int i = 1; i <= (int) Math.sqrt(n); i++) {
      count = Math.min(count, dp[n - i * i] == 0 ? dfs(n - i * i) + 1 : dp[n - i * i] + 1);
    }
    dp[n] = count;
    return count;
  }
}
/**
 * performance: 158 ms < 16%
 * time complexity:
 * space complexity: 
 */
