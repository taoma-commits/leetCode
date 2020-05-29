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
 * space complexity: O(depth) 
 * notes: recursion. 
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
 * space complexity: O(1)
 * notes: Morris traversal 
 */
