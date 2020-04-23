class Solution {
  public boolean canMeasureWater(int x, int y, int z) {
    if (z > x + y) return false;
    if (x + y < z) return false;
    if (x == 0 || y == 0) return z == 0 || x + y == z;
    if (x < y) return canMeasureWater(y, x, z);
    int temp = 0;
    while (y > 0) {
      temp = y;
      y = x % y;
      x = temp;
    }
    return z % x == 0;
  }
}

/**
 * performance: 0 ms < 100%, 36.5 MB < 50%
 * time complexity: the number of division in Euclidean algorithm.
 * space complexity: O(1)
 */
