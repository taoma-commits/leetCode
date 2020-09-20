class Solution {
  TreeNode x = null;
  TreeNode y = null;
  TreeNode pre = null;

  public void recoverTree(TreeNode root) {
    helper(root);
    int temp = x.val;
    x.val = y.val;
    y.val = temp;
  }

  private void helper(TreeNode node) {
    if (node.left != null) {
      helper(node.left);
    }
    if (pre != null && pre.val > node.val) {
      if (x == null) {
        x = pre;
      }
      y = node;
    }
    pre = node;
    if (node.right != null) {
      helper(node.right);
    }
  }
}

/**
 * performance: 2 ms < 100%
 * time complexity: O(n)
 * space complexity: O(height)
 * notes: recursive; in-order traversal. 
 */
