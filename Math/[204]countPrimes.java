class Solution {
  public int countPrimes(int n) {
    boolean[] nums = new boolean[n];
    for (int i = 2; i * i < n; i++) {
      if (!nums[i]) {
        for (int j = i * i; j < n; j += i) {
          nums[j] = true;
        }
      }
    }
    int count = 0;
    for (int i = 2; i < n; i++) {
      count += nums[i] ? 0 : 1;
    }
    return count;
  }
}

/**
 * performance: 14 ms < 90%, 38 MB < 9%
 * time complexity: O(n*log(log(n))) number theory
 * space complexity: O(n)
 * notes: The Sieve of Eratosthenes; combine two loops i * i overflows.
 */
