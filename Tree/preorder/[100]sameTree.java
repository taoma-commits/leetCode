class Solution {
  public boolean isSameTree(TreeNode p, TreeNode q) {
    if (p == null && q == null) return true;
    if (p == null || q == null) return false;
    if (p.val != q.val) {
      return false;
    } else {
      return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
  }
}

/**
 * performance: 0 ms < 100%
 * time complexity: O(n)
 * space complexity: best scenario O(log(n)); worst scenario O(n).
 * notes: recursion.
 */
 
