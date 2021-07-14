class Solution {
  public boolean isBalanced(TreeNode root) {
    return helper(root) > -1;
  }

  private int helper(TreeNode node) {
    if (node == null) return 0;
    int L = helper(node.left);
    int R = helper(node.right);
    if (L < 0 || R < 0 || Math.abs(L - R) > 1) {
      return -1;
    } else {
      return 1 + Math.max(L, R);
    }
  }
}

/**
 * performance: 1 ms < 100%
 * time complexity: O(n)
 * space complexity: O(depth)
 * notes: bottom-up recursion.
 */


class Solution {
  public boolean isBalanced(TreeNode root) {
    if (root == null) return true;
    if (isBalanced(root.left) && isBalanced(root.right)) {
      return Math.abs(maxDepth(root.left) - maxDepth(root.right)) < 2;
    }
    return false;
  }

  private int maxDepth(TreeNode root) {
    int depth = 0;
    if (root != null) {
      depth = 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
    return depth;
  }
}

/**
 * performance: 1 ms < 100%
 * time complexity: O(n^2) ?
 * space complexity: O(depth)
 * notes: Top-down recursion.
 */
