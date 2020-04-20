class Solution {
  public int[] plusOne(int[] digits) {
    for (int i = digits.length - 1; i >= 0; i--) {
      digits[i] = (digits[i] + 1) % 10;
      if (digits[i] != 0) {
        return digits;
      }
    }
    int[] res = new int[digits.length + 1];
    res[0] = 1;
    return res;
  }
}

/**
 * performance: 0 ms < 100% , 38 MB < 6%
 * time complexity: O(n);
 * space complexity: O(1) or O(n);
 */
