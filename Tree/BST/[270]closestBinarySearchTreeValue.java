class Solution {
  public int closestValue(TreeNode root, double target) {
    int V;
    int res = root.val;
    while (root != null) {
      V = root.val;
      if (Math.abs(root.val - target) < Math.abs(res - target)) {
        res = root.val;
      }
      root = target < V ? root.left : root.right;
    }
    return res;
  }
}

/**
 * performance: 0 ms < 100%
 * time complexity: O(height) !
 * space complexity: O(1)
 */


class Solution {
  public int closestValue(TreeNode root, double target) {
    int V = root.val;
    if (target < V && root.left != null) {
      int L = closestValue(root.left, target);
      if ((L + V) > 2 * target) V = L;
    }
    if (target > V && root.right != null) {
      int R = closestValue(root.right, target);
      if ((R + V) < 2 * target) V = R;
    }
    return V;
  }
}

/**
 * performance: 0 ms < 100%
 * time complexity: O(height)!
 * space complexity: O(height)
 */
