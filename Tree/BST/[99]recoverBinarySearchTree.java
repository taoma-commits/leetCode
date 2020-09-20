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

 class Solution {
  public void recoverTree(TreeNode root) {
    TreeNode pre = null;
    TreeNode x = null;
    TreeNode y = null;
    Deque<TreeNode> dq = new LinkedList<>();
    TreeNode node = root;
    while(node != null || !dq.isEmpty()) {
      while (node != null) {
        dq.addLast(node);
        node = node.left;
      }
      node = dq.removeLast();
      if (pre != null && pre.val > node.val) {
        y = node;
        if (x == null) {
          x = pre;
        }
      }
      pre = node;
      node = node.right;
    }
    swap(x, y);
  }

  private void swap(TreeNode x, TreeNode y) {
    int cache = x.val;
    x.val = y.val;
    y.val = cache;
  }
}

/**
 * performance: 4 ms < 38%
 * time complexity: O(n)
 * space complexity: O(height)
 * notes: iteration; in-order traversal.
 */
