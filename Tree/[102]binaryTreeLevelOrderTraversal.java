class Solution {
  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> res = new ArrayList<>();
    if (root == null) return res;
    Deque<TreeNode> queue1 = new ArrayDeque<>();
    Deque<TreeNode> queue2 = new ArrayDeque<>();
    queue1.addLast(root);
    while (!queue1.isEmpty()) {
      List<Integer> level = new ArrayList<>();
      while (!queue1.isEmpty()) {
        TreeNode node1 = queue1.removeLast();
        level.add(node1.val);
        queue2.addLast(node1);
      }
      res.add(level);
      while (!queue2.isEmpty()) {
        TreeNode node2 = queue2.removeLast();
        if (node2.right != null) queue1.addLast(node2.right);
        if (node2.left != null) queue1.addLast(node2.left);
      }
    }
    return res;
  }
}

/**
 * performance: 1 ms < 90%
 * time complexity: O(n)
 * space complexity: O(n)
 */
