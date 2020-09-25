class Solution {
  int count = 0;
  public int countUnivalSubtrees(TreeNode root) {
    isValid(root, 0);
    return count;
  }
  private boolean isValid (TreeNode node, int val) {
    if (node == null) return true;
    if (!isValid(node.left, node.val) | !isValid(node.right, node.val)) return false;
    count++;
    return node.val == val;
  }
}

/**
 * performance: 0 ms < 100%
 * time complexity: O(n)
 * space complexity: O(depth)
 * notes: 1. bitwise OR circumvents short-circuiting.
 * 2. isValid returns whether the node is the root of a uni-val subtree
 * and the uni-value is equal to the parent node value.  
 */
