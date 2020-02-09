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

        int[][] dp = new int[k + 1][n]; // the default value is zero
        for (int i = 1; i <= k; i++) { // fix a number of transaction
            int hold = - prices[0]; // the maximum profit right before the last sell at j
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], hold + prices[j]); // note
                hold = Math.max(hold, dp[i - 1][j] - prices[j]);
            }
        }
        return dp[k][n - 1];
    }
}

/**
* performance: 2 ms < 99%, 36.6 MB < 42.43%.
* tag: 2D dp 
* notes: dp[i][j] divided into two cases:
            case 1: last sell is done before reach j
            case 2: last sell is done exactly at j
          The profit in case 1 is dp[i][j - 1].
          The profit in case 2 is hold.
* companies: Amazon, Apple.
*/
