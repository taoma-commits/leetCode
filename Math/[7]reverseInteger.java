class Solution {
  public int reverse(int x) {
    int rev = 0;
    while (x != 0) {
      if (rev * 10 / 10 != rev) {
        return 0;
      }
      rev = rev * 10 + x % 10;
      x = x / 10;
    }
    return rev;
  }
}

/**
 * performance: 1 ms < 100%, 37 MB < 5%.
 */

/**
 * Prevent overflow and underflow
 * 1. The implementation works for negative Numbers
 *    because x % q is negative if x negative.
 * 2. If x is 10 digit decimal number, then
 *    the most significant digit is either 1 or 2.
 *    The last x % 10 has range 0 ~ 2. Therefore,
 *    rev * 10 + x % 10 overflow iff rev * 10 overflow.
 */
