// Definition for a binary tree node.
public class TreeNode {
   int val;
   TreeNode left;
   TreeNode right;
   TreeNode(int x) { val = x;}
}

// recursion
class Solution {
  public TreeNode invertTree(TreeNode root) {
    if (root != null) {
      TreeNode cache = invertTree(root.left);
      root.left = invertTree(root.right);
      root.right = cache;
    }
    return root;
  }
}

/**
 * performance: 0 ms < 100%
 * time complexity: O(n)
 * space complexity: O(height of tree)
 */


// iteration
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            if (node.left != null) stack.push(node.left);
            if (node.right != null) stack.push(node.right);
        }
        return root;
    }
}

/**
 * same
 */
