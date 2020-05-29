class Solution {
  List<Integer> res = new ArrayList<>();
  public List<Integer> inorderTraversal(TreeNode root) {
    if (root == null) return res;
    if (root.left != null) {
      inorderTraversal(root.left);
    }
    res.add(root.val);
    if (root.right != null) {
      inorderTraversal(root.right);
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
  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    Deque<TreeNode> stack = new ArrayDeque<>();
    TreeNode node = root;
    while (node != null || !stack.isEmpty()) {
      while (node != null) {
        stack.addLast(node);
        node = node.left;
      }
      node = stack.removeLast();
      res.add(node.val);
      node = node.right;
    }
    return res;
  }
}

/**
 * same
 * notes: replacing recursion with a stack
 */

class Solution {
  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    TreeNode node = root;
    while (node != null) {
      if (node.left == null) {
        res.add(node.val);
        node = node.right;
      } else {
        TreeNode pre = node.left;
        while (pre.right != null && pre.right != node) {
          pre = pre.right;
        }
        if (pre.right == null) {
          pre.right = node;
          node = node.left;
        } else {
          res.add(node.val);
          pre.right = null;
          node = node.right;
        }
      }
    }
    return res;
  }
}

/**
 * same 
 * notes: Morris traversal 
 */
 
 
