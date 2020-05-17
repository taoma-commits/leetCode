class Solution {
  public int uniquePaths(int m, int n) {
    if (m < n) return uniquePaths(n, m);
    int[] dp = new int[n];
    Arrays.fill(dp, 1);
    for (int j = 1; j < m; j++) {
      for (int i = n - 2; i > -1; i--) {
        dp[i] = dp[i] + dp[i + 1];
      }
    }
    return dp[0];
  }
}

/**
 * performance: 0 ms < 100%
 * time complexity: O(m * n)
 * space complexity: O(min(m, n))
 * notes: 2d dp -> 1d dp
 */


class Solution {
  public int uniquePaths(int m, int n) {
    if (n < m) return uniquePaths(n, m);
    long numerator = 1, denomenator = 1;
    for (int i = 1; i < m; i++) {
      numerator *= (n - 1) + i;
      denomenator *= i; 
    }
    return (int) (numerator / denomenator);
  }
}
/**
 * performance: 0 ms < 100%
 * time complexity: O(min(m, n))
 * space complexity: O(1)
 * notes: permutations
 */
 
