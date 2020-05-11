class Solution {
  public int minimumTotal(List<List<Integer>> T) {
    int n = T.size();
    int[] dp = new int[n + 1];
    for (int i = n - 1; i > -1; i--) {
      for (int j = 0; j < i + 1; j++) {
        dp[j] = T.get(i).get(j) + Math.min(dp[j], dp[j + 1]);
      }
    }
    return dp[0];
  }
}

/**
 * performance: 2 ms < 97%
 * time complexity: O(n^2)
 * space complexity: O(n)
 */
