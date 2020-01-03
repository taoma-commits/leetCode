/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Best Time to Buy and Sell Stock II.
Memory Usage: 37.4 MB, less than 100.00% of Java online submissions for Best Time to Buy and Sell Stock II.
@dataStructure: array 
*/

class Solution {
    public int maxProfit(int[] prices) {
        int profit, last, diff;
        diff = profit = 0;
        last = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            diff = prices[i] - last;
            last = prices[i];
            if (diff > 0) profit += diff;
        }
        return profit;
    }
}
