class Solution {
  int max = Integer.MIN_VALUE;
  public int maxPathSum(TreeNode root) {
    helper(root);
    return max;
  }
  private int helper(TreeNode node) {
    int res = 0;
    if (node != null) {
      int L = helper(node.left);
      int R = helper(node.right);
      res = Math.max(0, Math.max(L, R)) + node.val;
      max = Math.max(max, Math.max(res, L + R + node.val));
    }
    return res;
  }
}

/**
 * performance: 1 ms < 100%
 * time complexity: O(n)
 * space complexity: O(depth)
 * notes: 0. bottom-up recursion.  
 * 1. max set to -infty b/c leaf node could be any negative number.
 * 2. helper returns the max sum of path ends at the current node.
 */
