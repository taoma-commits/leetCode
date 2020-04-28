class Solution {
  int divisor = 1337;
  public int superPow(int a, int[] b) {
    a = a % divisor;
    int period = period(a);
    int B = 0;
    for (int i = 0; i < b.length; i++) {
      B = (B * 10 + b[i]) % period;
    }
    int res = 1;
    int base = a;
    while (B != 0) {
      res = (res * (power(base, B % 10))) % divisor;
      B = B / 10;
      base = power(base, 10);
    }
    return res;
  }

  private int power(int base, int exponent) {
    int power = 1;
    for (int i = 0; i < exponent; i++) {
      power = (power * base) % divisor;
    }
    return power;
  }

  private int period(int a) {
    if ((a % 191) == 0) return 6;
    if ((a % 7) == 0) return 190;
    return 570;
  }
}

/**
 * performance: 1 ms < 100%, 40 MB < 100%
 * time complexity: O(n)
 * space complexity: O(1)
 */
