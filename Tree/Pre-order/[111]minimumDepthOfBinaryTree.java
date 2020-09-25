class Solution {
  int min = Integer.MAX_VALUE;
  int depth = 0;
  public int minDepth(TreeNode root) {
    if (root == null) return depth;
    depth += 1;
    if (root.left == null && root.right == null) {
      min = Math.min(min, depth);
    }
    if (root.left != null) {
      minDepth(root.left);
    }
    if (root.right != null) {
      minDepth(root.right);
    }
    depth -= 1;
    return min;
  }
}

/**
 * performance: 0 ms < 100%
 * time complexity: O(n)
 * space complexity: O(depth)
 */
