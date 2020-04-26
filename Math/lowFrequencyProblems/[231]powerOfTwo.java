class Solution {
  public boolean isPowerOfTwo(int n) {
    if (n == 0) return false;
    long x = n; // cast to long type
    return (x & (- x)) == x;
  }
}
/**
 * performance: 1 ms < 100%, 37 MB < 7%
 * time complexity: O(1)
 * space complexity: O(1)
 * notes: 1. if n = -2^31, then (n & (-n)) == n is true.
 * 2. x & -x gets the right-most 1.
 */

 class Solution {
   public boolean isPowerOfTwo(int n) {
     if (n == 0) return false;
     long x = n;
     return (x & x - 1) == 0;
   }
 }
/**
 * performance: 1 ms < 100%, 37 MB < 7%
 * time complexity: O(1)
 * space complexity: O(1)
 * notes: x & x - 1 removes the right-most 1
 */
