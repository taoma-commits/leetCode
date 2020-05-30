class Solution {
  List<Integer> res = new ArrayList<>();
  public List<Integer> postorderTraversal(TreeNode root) {
    if (root != null) {
      if (root.left != null) {
        postorderTraversal(root.left);
      }
      if (root.right != null) {
        postorderTraversal(root.right);
      }
      res.add(root.val);
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
  public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    Deque<TreeNode> stack = new ArrayDeque<>();
    TreeNode node = root;
    if (node == null) return res;
    stack.addLast(node);
    while (!stack.isEmpty()) {
      TreeNode peek = stack.getLast();
      if (peek.left != null && peek.left != node && peek.right != node) {
        stack.addLast(peek.left);
      } else if (peek.right != null && peek.right != node) {
        stack.addLast(peek.right);
      } else {
        node = stack.removeLast();
        res.add(node.val);
      }
    }
    return res;
  }
}
/**
 * performance: 1 ms 
 * time complexity: O(n)
 * space complexity: O(n)
 * notes: replacing recursion with a stack. 
 */

class Solution {
  public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    if (root == null) return res;
    Deque<TreeNode> stack1 = new ArrayDeque<>();
    Deque<TreeNode> stack2 = new ArrayDeque<>();
    stack1.addLast(root);
    while (!stack1.isEmpty()) {
      TreeNode node = stack1.removeLast();
      stack2.addLast(node);
      if (node.left != null) stack1.addLast(node.left);
      if (node.right != null) stack1.addLast(node.right);
    }
    while (!stack2.isEmpty()) {
      res.add(stack2.removeLast().val);
    }
    return res;
  }
}

/**
 * performance: 1 ms
 * same
 * notes: two stacks. 
 */


 
