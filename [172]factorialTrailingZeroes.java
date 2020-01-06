/*
Runtime: 1 ms, faster than 97.89% of Java online submissions for Factorial Trailing Zeroes.
Memory Usage: 33.6 MB, less than 7.69% of Java online submissions for Factorial Trailing Zeroes.
*/


class Solution {
    public int trailingZeroes(int n) {
        int result = 0;
        while (n != 0) {
            n = n / 5;
            result += n;
        }
        return result;
    }
}
