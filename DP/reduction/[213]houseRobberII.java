class Solution {
  public int rob(int[] nums) {
    if (nums.length == 0) return 0;
    if (nums.length == 1) return nums[0];
    int p1 = 0;
    int c1 = 0;
    int p2 = 0;
    int c2 = 0;
    for (int i = 0; i < nums.length - 1; i++) {
      int temp = c1;
      c1 = Math.max(p1 + nums[i], c1);
      p1 = temp;
      temp = c2;
      c2 = Math.max(p2 + nums[i + 1], c2);
      p2 = temp;
    }
    return Math.max(c1, c2);
  }
}

/**
 * performance: 0 ms < 100%
 * time complexity: O(n)
 * space complexity: O(1)
 */

class Solution {
  public int rob(int[] nums) {
    if(nums.length == 1) return nums[0]; 
    int preMax = 0;
    int max = 0;
    for (int i = 0; i < nums.length - 1; i++) {
      int temp = max;
      max = Math.max(max, preMax + nums[i]);
      preMax = temp;
    }
    int res = max;
    preMax = 0;
    max = 0;
    for (int i = 1; i < nums.length; i++) {
      int temp = max;
      max = Math.max(max, preMax + nums[i]);
      preMax = temp;
    }
    return Math.max(res, max);
  }
}

/**
 * same 
 */
