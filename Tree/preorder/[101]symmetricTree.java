class Solution {
  public boolean isSymmetric(TreeNode root) {
    if (root == null) return true;
    return helper(root.left, root.right);
  }
  private boolean helper(TreeNode L, TreeNode R) {
    if (L == null && R == null) return true;
    if (L == null || R == null) return false;
    if (L.val != R.val) return false;
    return helper(L.left, R.right) && helper(L.right, R.left);
  }
}

/**
 * performance: 0 ms < 100%
 * time complexity: O(n)
 * space complexity: best O(log(n)); worst O(n).
 * notes: recursion.
 */
