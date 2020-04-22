class Solution {
  public int divide(int A, int B) {
    if (A == Integer.MIN_VALUE && B == -1) return Integer.MAX_VALUE;
    int a = Math.abs(A);
    int b = Math.abs(B);
    int res = 0;
    while (a - b >= 0) {
      int shift = 0;
      while (a - (b << shift << 1) >= 0) {
        shift++;
      }
      res += 1 << shift;
      a -= b << shift;
    }
    return ((A ^ B) >= 0) ? res : -res;
  }
}

/**
 * performance: 1 ms < 100%, 37 MB < 8%
 * time complexity: O(lg())
 * space complexity:
 * notes:
 */
