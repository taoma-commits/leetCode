class Solution {
  public boolean isPerfectSquare(int num) {
    double x = (double) num;
    double y = x;
    long Y = (long) num; // avoid Y*Y overflow
    while ((double) (Y * Y) > x) {
      y = (y + x / y) / 2;
      Y = (long) y;
    }
    return Y * Y == num; // valid conversion: Y ~= num
  }
}

/**
 * performance: 0 ms < 100%, 36 MB < 10%
 * time complexity:
 * space complexity:
 * notes: Newton's method;
 * pay attention to while condition.
 */
