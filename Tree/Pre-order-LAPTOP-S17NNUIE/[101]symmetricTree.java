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

class Solution {
  public boolean isSymmetric(TreeNode root) {
    if (root == null) return true;
    Deque<TreeNode> dq = new ArrayDeque<>();
    if (!checkNodes(root.left, root.right)) return false;
    if (root.left != null) {
      dq.addLast(root.left);
      dq.addFirst(root.right);
    }
    while (!dq.isEmpty()) {
      TreeNode L = dq.removeLast();
      TreeNode R = dq.removeFirst();
      if (!checkNodes(L.right, R.left) || !checkNodes(L.left, R.right)) return false;
      if (L.right != null) {
        dq.addLast(L.right);
        dq.addFirst(R.left);
      }
      if (L.left != null) {
        dq.addLast(L.left);
        dq.addFirst(R.right);
      }
    }
    return true;
  }

  private boolean checkNodes(TreeNode p, TreeNode q) {
    if (p == null && q == null) return true;
    if (p == null || q == null) return false; 
    return p.val == q.val;
  }
}

/**
 * performance: 2 ms < 9%
 * same
 * notes: replacing recursion with a deque. 
 */
