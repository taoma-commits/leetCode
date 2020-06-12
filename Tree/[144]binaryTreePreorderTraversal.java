class Solution {
  List<Integer> res = new ArrayList<>();
  public List<Integer> preorderTraversal(TreeNode root) {
    if (root != null) {
      res.add(root.val);
      preorderTraversal(root.left);
      preorderTraversal(root.right);
    }
    return res;
  }
}

/**
 * performance: 0 ms < 100%
 * time complexity: O(n)
 * space complexity: O(n)
 * notes: recursion.
 */

class Solution {
  public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    Deque<TreeNode> stack = new ArrayDeque<>();
    if (root != null) stack.addLast(root);
    while (!stack.isEmpty()) {
      TreeNode node = stack.pollLast();
      res.add(node.val);
      if (node.right != null) stack.addLast(node.right);
      if (node.left != null) stack.addLast(node.left);
    }
    return res;
  }
}

/**
 * performance: 0 ms
 * time complexity: O(n)
 * space complexity: O(n)
 * notes: use stack to convert recursion to iteration. 
 */

class Solution {
  public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    if (root == null) return res;
    Deque<TreeNode> stack = new ArrayDeque<>();
    stack.addLast(root);
    TreeNode N = new TreeNode(0);
    while (!stack.isEmpty()) {
      TreeNode node = stack.removeLast();
      if (node != N) {
        if (node.right != null) stack.addLast(node.right);
        if (node.left != null) stack.addLast(node.left);
        stack.addLast(node);
        stack.addLast(N);
      } else {
        res.add(stack.removeLast().val);
      }
    }
    return res;
  }
}

/**
 * performance: 1ms
 * notes: template for all traversal problems
 */

class Solution {
  public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    TreeNode node = root;
    TreeNode pre;
    while (node != null) {
      if (node.left == null) {
        res.add(node.val);
        node = node.right;
      } else {
        pre = node.left;
        while (pre.right != null && pre.right != node) {
          pre = pre.right;
        }
        if (pre.right == null) {
          res.add(node.val);
          pre.right = node;
          node = node.left;
        } else {
          node = node.right;
          pre.right = null;
        }
      }
    }
    return res;
  }
}

/**
 * performance: 0 ms
 * time complexity: O(n)
 * space complexity: O(n)
 * notes: Morris traversal
 */
