class Solution {
  public int maxCoins(int[] nums) {
    int n = nums.length;
    int[] p = new int[n + 2];
    for (int i = 1; i < n + 1; i++) {
      p[i] = nums[i - 1];
    }
    p[0] = 1;
    p[n + 1] = 1;
    int[][] dp = new int[n + 2][n + 2];
    for (int j = 0; j < n; j++) {
      for (int i = 1; i + j < n + 1; i++) {
        int max = Integer.MIN_VALUE;
        for (int k = i; k < i + j + 1; k++) {
          max = Math.max(max, p[i - 1] * p[k] * p[i + j + 1] + dp[i][k - 1] + dp[k + 1][i + j]);
        }
        dp[i][i + j] = max;
      }
    }
    return dp[1][n]; 
  }
}
/**
 * performance: 8 ms < 81%
 * time complexity: O(n^3)
 * space complexity: O(n^2)
 * notes: padding 
 */
