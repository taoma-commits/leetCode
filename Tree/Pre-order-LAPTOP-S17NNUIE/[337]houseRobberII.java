class Solution {
  public int rob(TreeNode root) {
    return helper(root)[1];
  }
  private int[] helper(TreeNode node) {
    int[] cache = new int[2];
    if (node != null) {
      int[] L = new int[2];
      int[] R = new int[2];
      if (node.left != null) {
        L = helper(node.left);
      }
      if (node.right != null) {
        R = helper(node.right);
      }
      cache[0] = L[1] + R[1];
      cache[1] = Math.max(L[0] + R[0] + node.val, cache[0]);
    }
    return cache;
  }
}

/**
 * performance: 1 ms < 84%
 * time complexity: O(n)
 * space complexity: O(depth)
 */
