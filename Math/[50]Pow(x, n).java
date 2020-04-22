class Solution {
  public double myPow(double x, int n) {
    if (n == 0) return (double) 1;
    if (n < 0)  {
      n = -n;
      x = 1 / x;
    }
    double y = 1;
    for (long long i = 0; i < n; i++) {
      y = y * x;
    }
    return y;
  }
}

/**
 * performance: exceeds time limit
 * time complexity: O(n)
 * space complexity: O(1)
 */
