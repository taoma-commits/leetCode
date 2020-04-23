class Solution {
  public int mySqrt(int x) {
    if (x < 2) return x;
    double y = x;
    while ( Math.abs(y - (y + x / y) / 2.0) >= 1) {
      y = (y + x / y) / 2.0;
    }
    return (int) (y + x / y) / 2;
  }
}

/**
 * performance: 1 ms < 100%, 37 MB < 6%
 * time complexity: O(log x)
 * space complexity: O(1)
 * notes: Newton's method 
 */



/**
 * performance:
 * time complexity:
 * space complexity:
 * notes: binary search
 */

/**
 * performance:
 * time complexity:
 * space complexity:
 * notes: recursion + bit manipulation
 */

/**
 * performance:
 * time complexity:
 * space complexity:
 * notes: logarithm and exponential
 */
