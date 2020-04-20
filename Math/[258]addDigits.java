class Solution {
  public int addDigits(int num) {
    return (num - 1) % 9 + 1;
  }
}

/**
 * performance: 1 ms < 100% 
 * time complexity: O(1)
 */
