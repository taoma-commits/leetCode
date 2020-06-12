class Solution {
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (p.val > q.val) return lowestCommonAncestor(root, q, p);
    TreeNode parent = root;
    TreeNode pNode = p;
    TreeNode qNode = q;
    while (parent.val < pNode.val || parent.val > qNode.val) {
      if (parent.val < pNode.val) parent = parent.right;
      if (parent.val > qNode.val) parent = parent.left;
    }
    return parent;
  }
}

/**
 * performance: 6 ms < 99%
 * time complexity: O(depth)
 * space complexity: O(1)
 */


class Solution {
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (p.val > q.val) return lowestCommonAncestor(root, q, p);
    if (root.val < p.val) return lowestCommonAncestor(root.right, p, q);
    if (root.val > q.val) return lowestCommonAncestor(root.left, p, q);
    return root;
  }
}

/**
 * performance: 6 ms < 99%
 * time complexity: O(depth)
 * space complexity: O(depth)
 */
