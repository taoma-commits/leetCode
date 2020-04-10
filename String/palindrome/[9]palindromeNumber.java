class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int y = 0;
        while (y < x) {
            y = y * 10 + x % 10;
            x = x / 10;
        }
        return (x == y) || (x == y / 10);
    }
}

/**
 * performance: 9 ms < 100%, 38 MB < 5%
 * notes: 1. reverse half
 *        2. tricky corner cases: x % 10 = 0 and x = 0
 */
