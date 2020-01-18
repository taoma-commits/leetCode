/*
Runtime: 1 ms, faster than 100.00% of Java online submissions for Power of Four.
Memory Usage: 38.8 MB, less than 6.67% of Java online submissions for Power of Four.
*/

class Solution {
    public boolean isPowerOfFour(int num) {
        if (num <= 0) return false;
        while ((num & 3) == 0) num >>= 2;
        return (num & 3) == 1 && (num >> 2) == 0;
    }
}


/*
Runtime: 1 ms, faster than 100.00% of Java online submissions for Power of Four.
Memory Usage: 38.9 MB, less than 6.67% of Java online submissions for Power of Four.
Iteration-free solution
*/
class Solution {
    public boolean isPowerOfFour(int num) {
        return num > 0 && (num & (num - 1)) == 0 && (num & 0x55555555) != 0;
    }
}

/*
Runtime: 1 ms, faster than 100.00% of Java online submissions for Power of Four.
Memory Usage: 39.6 MB, less than 6.67% of Java online submissions for Power of Four.
Another iteration-free solution
*/
class Solution {
    public boolean isPowerOfFour(int num) {
        return num > 0 && (num & (num - 1)) == 0 && (num % 3) == 1;
    }
}
