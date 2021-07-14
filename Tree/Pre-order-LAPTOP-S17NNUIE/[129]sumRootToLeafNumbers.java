class Solution {
  int sum = 0;
  int pathSum = 0;
  public int sumNumbers(TreeNode root) {
    if (root != null) {
      backtrack(root);
    }
    return sum;
  }

  private void backtrack(TreeNode node) {
    pathSum = (pathSum * 10) + node.val;
    if (node.left == null && node.right == null) {
      sum += pathSum;
    } else {
      if (node.left != null) {
        backtrack(node.left);
      }
      if (node.right != null) {
        backtrack(node.right);
      }
    }
    pathSum /= 10;
  }
}

/**
 * performance: 0 ms < 100%
 * time complexity: O(n)
 * space complexity: O(depth)
 * notes: backtracking
 */
