class Solution {
  Deque<TreeNode> stack = new LinkedList<>();
  public int kthSmallest(TreeNode root, int k) {
    TreeNode node = root;
    while (true) {
      while (node != null) {
        stack.addLast(node);
        node = node.left;
      }
      node = stack.removeLast();
      if (--k == 0) return node.val;
      node = node.right;
    }
  }
}

/**
 * performance: 0 ms < 100%
 * time complexity: O(n)
 * space complexity: O(depth)
 * notes: in-order traversal using stack.
 */


class Solution {
  Deque<TreeNode> stack = new LinkedList<>();
  public int kthSmallest(TreeNode root, int k) {
    TreeNode next = root;
    TreeNode node = null;
    for (int i = 0; i < k; i++) {
      helper(next);
      node = stack.removeLast();
      next = node.right;
    }
    return node.val;
  }
  private void helper(TreeNode node) {
    while (node != null) {
      stack.addLast(node);
      node = node.left;
    }
  }
}

/**
 * same
 */
