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
 
class Solution {
  public boolean isSameTree(TreeNode pNode, TreeNode qNode) {
    if (pNode == null && qNode == null) return true;
    if (!checkNodes(pNode, qNode)) return false;
    Deque<TreeNode> P = new ArrayDeque<>();
    Deque<TreeNode> Q = new ArrayDeque<>();
    P.addLast(pNode);
    Q.addLast(qNode);
    while (!P.isEmpty() && !Q.isEmpty()) {
      TreeNode p = P.removeLast();
      TreeNode q = Q.removeLast();
      if (!checkNodes(p.left, q.left)) return false;
      if (!checkNodes(p.right, q.right)) return false;
      if (p.left != null && q.left != null) {
        P.addLast(p.left);
        Q.addLast(q.left);
      }
      if (p.right != null && q.right != null) {
        P.addLast(p.right);
        Q.addLast(q.right);
      }
    }
    return P.isEmpty() && Q.isEmpty();
  }

  private boolean checkNodes(TreeNode p, TreeNode q) {
    if (p == null && q == null) return true;
    if (p == null || q == null) return false; 
    return p.val == q.val;
  }
}

/**
 * same
 * notes: double stacks replacing recursion. 
 */
