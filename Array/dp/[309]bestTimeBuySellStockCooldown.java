class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int[] dp = new int[5];
        dp[0] = - prices[0]; // dp[0] = max profit holding stock before i
        for (int i = 1; i < prices.length; i++) {
            // dp[1] = max profit at i - 1; dp[2] = max profit at i - 2; dp[3] = max profit at i - 3.
            dp[4] = dp[1]; // dp[4] temporary store
            dp[1] = Math.max(dp[1], prices[i] + dp[0]);
            dp[3] = dp[2];
            dp[2] = dp[4];
            dp[0] = Math.max(dp[0], dp[3] - prices[i]);
        }
        return dp[1];
    }
}

/**
* performance: 1 ms < 100%, 36 MB < 41%.
* tag: dp 
* companies: Facebook
*/
