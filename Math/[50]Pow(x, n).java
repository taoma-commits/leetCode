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

class Solution {
  public double myPow(double x, int n) {
    long N = n; //cast to long type for the case n = -2^31
    if (N < 0) {
      N = -N; // int type would overflow if n = -2^31
      x = 1 / x;
    }
    int mask = 1;
    double res = 1, base = x;
    while (N > 0) {
      if ((mask & N) == 1) {
        res = res * base;
      }
      base = base * base;
      N = (N >> 1); // right shift faster than /2
    }
    return res;
  }
}

/**
 * performance: 1 ms < 96%, 36 MB < 7%
 * time complexity: O(lg(n))
 * space complexity: O(1)
 * notes: fast exponentiation algorithm
 */
