/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Invert Binary Tree.
Memory Usage: 39.8 MB, less than 5.10% of Java online submissions for Invert Binary Tree.
*/


// Definition for a binary tree node.
public class TreeNode {
   int val;
   TreeNode left;
   TreeNode right;
   TreeNode(int x) { val = x;}
}

// recursive solution
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = invertTree(right);
        root.right = invertTree(left);
        return root;
    }
}

/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Invert Binary Tree.
Memory Usage: 40.2 MB, less than 5.10% of Java online submissions for Invert Binary Tree.
@stack
*/

// iterative solution
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
