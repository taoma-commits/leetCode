class Solution {
  public static int[] dp = new int[10]; 
  public int numSquares(int n) {
    if (dp.length < n + 1) {
      int[] copy = new int[2 * n];
      for (int i = 1; i < dp.length; i++) {
        copy[i] = dp[i];
      }
      dp = copy;
    }
    if (n == 0) return 0;
    for (int i = 1; i < n + 1; i++) {
      if (dp[i] != 0) continue;
      int count = i;
      for (int j = (int) Math.sqrt(i); j > 0; j--) {
        count = Math.min(count, dp[i - j * j] + 1);
      }
      dp[i] = count;
    }
    return dp[n];
  }
}
/**
 * performance: 2 ms < 98%
 * time complexity: O(n*sqrt(n)) (not amortized)
 * space complexity: O(n)
 * notes: Use a static variable to store previously computed results.
 */
