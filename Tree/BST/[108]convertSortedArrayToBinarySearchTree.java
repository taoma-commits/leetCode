class Solution {
  public TreeNode sortedArrayToBST(int[] nums) {
    if (nums.length == 0) return null;
    return helper(nums, 0, nums.length - 1);
  }
  private TreeNode helper(int[] nums, int lo, int hi) {
    int idx = 1 + (lo + hi) >> 1;
    TreeNode root = new TreeNode(nums[idx]);
    if (lo <= idx - 1) root.left = helper(nums, lo, idx - 1);
    if (hi >= idx + 1) root.right = helper(nums, idx + 1, hi);
    return root;
  }
}

/**
 * performance: 0 ms < 100%
 * time complexity: O(n)
 * space complexity: O(n)
 */
