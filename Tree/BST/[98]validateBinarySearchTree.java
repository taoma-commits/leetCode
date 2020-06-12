class Solution {
  public boolean isValidBST(TreeNode root) {
    if (root == null) return true;
    return helper(root, null, null);
  }

  private boolean helper(TreeNode node, Integer hi, Integer lo) {
    if (hi != null && node.val >= hi) return false;
    if (lo != null && node.val <= lo) return false;
    if (node.left != null && !helper(node.left, node.val, lo)) return false;
    if (node.right != null && !helper(node.right, hi, node.val)) return false;
    return true;
  }
}

/**
 * performance: 0 ms < 100%
 * time complexity: O(n)
 * space complexity: O(depth)
 * notes: pre-order traversal; trick use Integer type and null control overflow and underflow.
 */
 
 
