class Solution {
  public int rob(int[] nums) {
    int prev = 0; 
    int current = 0;
    for (int i = 0; i < nums.length; i++) {
      int temp = current;
      current = Math.max(current, prev + nums[i]);
      prev = temp;
    }
    return current;
  }
}

/**
 * performance: 0 ms < 100%
 * time complexity: O(n)
 * space complexity: O(1)
 */
