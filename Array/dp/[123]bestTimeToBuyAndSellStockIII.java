class Solution {
    public int maxProfit(int[] prices) {

        int buy1 = Integer.MIN_VALUE;
        int buy2 = Integer.MIN_VALUE;
        int sell1 = 0;
        int sell2 = 0;

        for (int price : prices) {
            sell2 = Math.max(sell2, buy2 + price); // the max profit of two transactions so far
            buy2 = Math.max(buy2, sell1 - price); // the max profit of one transaction and one buy so far
            sell1 = Math.max(sell1, buy1 + price); // the max profit of one transaction so far
            buy1 = Math.max(buy1, - price); // the negative of the min price occured so far
        }

        return sell2;
    }
}

/**
* performance: 1 ms < 100%, 37 MB < 80%.
* tag: 1D dp
* notes: the inner loop of [188].
*/
