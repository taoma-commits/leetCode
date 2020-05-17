class Solution {
  public int coinChange(int[] coins, int amount) {
    int[] dp = new int[amount + 1];
    for (int i = 1; i < amount + 1; i++) {
      int min = Integer.MAX_VALUE;
      for (int coin : coins) {
        if (coin <= i && dp[i - coin] > -1) {
          min = Math.min(min, dp[i - coin] + 1);
        }
      }
      dp[i] = (min == Integer.MAX_VALUE) ?  -1 : min;
    }
    return dp[amount];
  }
}

/**
 * performance: 14 ms < 85% 
 * time complexity: O(n*m)
 * space complexity: O(n)
 */
