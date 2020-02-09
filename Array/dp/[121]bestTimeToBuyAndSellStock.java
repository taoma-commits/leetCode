class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] - min > profit) {
                profit = prices[i] - min;
            } else if (prices[i] < min) {
                min = prices[i];
            }
        }
        return profit;
    }
}

/*
* performance: 0 ms < 100%, 36.8 MB < 100%.R
* tag: dp
*/
