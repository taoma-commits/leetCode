class BSTIterator {
  TreeNode R;
  Deque<TreeNode> stack = new LinkedList<>();
  public BSTIterator(TreeNode root) {
    TreeNode node = root;
    while (node != null) {
      stack.addLast(node);
      node = node.left;
    }
  }

  /** @return the next smallest number */
  public int next() {
    TreeNode next = stack.removeLast();
    TreeNode node = next.right;
    while (node != null) {
      stack.addLast(node);
      node = node.left;
    }
    return next.val;
  }

  /** @return whether we have a next smallest number */
  public boolean hasNext() {
    return !stack.isEmpty();
  }
}

/**
 * performance: 23 ms < 95%
 * time complexity: hasNext() O(1); next() average O(1).
 * space complexity: O(depth)
 * notes: In-order traversal using stack.
 */
