public class Solution {
    public boolean isPowerOfThree(int n) {
        return n > 0 && 1162261467 % n == 0;
    }
}

/**
 * performance: 15 ms < 95%
 * time complexity: O(1)
 * space complexity: O(1)
 * notes: 1162261467 = 3^19 the largest power of 3 not overflow.
 * An integer divides 3^19 iff it is a power of 3. 
 */
