class Solution {
  public int maxSubArray(int[] nums) {
    int dp = nums[0];
    int max = nums[0];
    for (int i = 1; i < nums.length; i++) {
      dp = Math.max(dp + nums[i], nums[i]);
      max = Math.max(max, dp);
    }
    return max;
  }
}

/**
 * performance: 1 ms < 95%
 * time complexity: O(n)
 * space complexity: O(1)
 * notes: DP
 */
