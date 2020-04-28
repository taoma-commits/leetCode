class Solution {
  public int findNthDigit(int n) {
    n -= 1;
    int len = 1;
    long start = 1;
    while (n > len * 9 * start) {
      n -= len * 9 * start;
      start *= 10;
      len++;
    }
    return Integer.toString((int) start + n / len).charAt(n % len) - '0';
  }
}

/**
 * performance: 0 ms < 100%, 37 MB < 50%
 * time complexity: O(log(n))
 * space complexity: O(log(n))! length of string.
 */
