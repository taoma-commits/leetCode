class Solution {
    public int maxProfit(int k, int[] prices) {

        int n = prices.length;

        if (k >= n / 2) {
            int profit = 0;
            for (int i = 1; i < n; i++) {
                if (prices[i] > prices[i - 1]) {
                    profit += prices[i] - prices[i - 1];
                }
            }
            return profit;
        }

        int[][] dp = new int[k + 1][n];
        for (int i = 1; i <= k; i++) {
            int hold = - prices[0];
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], hold + prices[j]);
                hold = Math.max(hold, dp[i - 1][j] - prices[j]);
            }
        }
        return dp[k][n - 1];
    }
}

/**
* performance: 2 ms < 99%, 36.6 MB < 42.43%.
* notes:
      1. 
      2.
      3.
*
*/
