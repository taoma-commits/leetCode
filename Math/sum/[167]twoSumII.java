class Solution {
  public int[] twoSum(int[] nums, int target) {
    int l = 0, r = nums.length - 1;
    while (nums[l] + nums[r] != target) {
      if (nums[l] + nums[r] < target) l++;
      if (nums[l] + nums[r] > target) r--;
    }
    return new int[]{l + 1, r + 1};
  }
}

/**
 * performance: 1 ms < 98%, 39 MB < 7%
 * time complexity: O(n)
 * space complexity: O(1)
 */
