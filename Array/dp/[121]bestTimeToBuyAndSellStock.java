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
* Runtime: 0 ms, faster than 100.00% of Java online submissions for Best Time to Buy and Sell Stock.
* Memory Usage: 36.8 MB, less than 100.00% of Java online submissions for Best Time to Buy and Sell Stock.
* notes: dynamical programming.
*/
