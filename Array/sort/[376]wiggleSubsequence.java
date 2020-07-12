class Solution {
  public int wiggleMaxLength(int[] nums) {
    int n = nums.length;
    if (n < 2) return n;
    int len = 1;
    int preDiff = 0;
    for (int i = 1; i < n; i++) {
      int diff = nums[i] - nums[i - 1];
      if (diff != 0 && diff * preDiff <= 0) {
        len++;
        preDiff = diff;
      }
    }
    return len;
  }
}

/**
 * performance: 0 ms < 100%
 * time complexity: O(n)
 * space complexity: O(1)
 */
