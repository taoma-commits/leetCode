class Solution {
  public int numWays(int n, int k) {
    if (n == 0) return 0;
    int same = 0;
    int dif = k;
    for (int i = 1; i < n; i++) {
      int temp = dif;
      dif = (same + dif) * (k - 1);
      same = temp;
    }
    return same + dif;
  }
}
/**
 * performance: 0 ms < 100%, 36 MB < 100%
 * time complexity: O(n)
 * space complexity: O(1)
 */
