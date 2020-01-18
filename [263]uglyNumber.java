/*
Runtime: 1 ms, faster than 100.00% of Java online submissions for Ugly Number.
Memory Usage: 39.2 MB, less than 6.25% of Java online submissions for Ugly Number.
*/

class Solution {
    public boolean isUgly(int num) {
        if (num <= 0) return false;
        while (num % 2 == 0) num /= 2;
        while (num % 3 == 0) num /= 3;
        while (num % 5 == 0) num /= 5;
        return num == 1;
    }
}
