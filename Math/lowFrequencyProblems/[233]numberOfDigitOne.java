class Solution {
  public int countDigitOne(int n) {
    int res = 0;
    long a = 1, b = n % 10,  c = n / 10;
    for (int i = 0; n - a >= 0; i++) {
      res += c * a + Math.min(a, Math.max(0, b - a + 1));
      a = a * 10;
      b = n % (a * 10);
      c = n / (a * 10);
    }
    return (int) res;
  }
}

/**
 * performance: 0 ms < 100%, 36.6 MB < 33%
 * time complexity: O(log(n))
 * space complexity: O(1)
 * notes: 1. # of 1's at k-th position is
 * (n / 10^(k+1)) * 10^k + min(10^k, max(n%(10^(k+1)) - 10^k + 1, 0))
 * 2. for large n, a, b, and c overflow.
 */
