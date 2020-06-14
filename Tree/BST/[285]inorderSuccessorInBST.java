class Solution {
  int k;
  public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
    // The following part is not necessary and does not improve performance in practice.
    // if (p.right != null) {
    //   TreeNode node = p.right;
    //   while (node.left != null) node = node.left;
    //   return node;
    // }
    k = p.val;
    return helper(root);
  }
  private TreeNode helper(TreeNode node) {
    if (node == null) return null;
    if (k < node.val) {
      TreeNode L = helper(node.left);
      if (L == null) return node;
      return L;
    } else {
      return helper(node.right);
    }
  }
}

/**
 * performance: 3 ms < 99%
 * time complexity: O(n)
 * space complexity: O(depth) 
 */
