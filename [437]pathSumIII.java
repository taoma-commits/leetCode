/*
Runtime: 12 ms, faster than 19.10% of Java online submissions for Path Sum III.
Memory Usage: 46.4 MB, less than 6.82% of Java online submissions for Path Sum III.
*/

class Solution {
    private int path(TreeNode node, int sum) {
        int count = 0;
        if (node != null) {
            sum -= node.val;
            if (sum == 0) count++;
            count += path(node.left, sum);
            count += path(node.right, sum);
        }
        return count;
    }
    public int pathSum(TreeNode root, int sum) {
        Stack<TreeNode> stack = new Stack<>();
        int count = 0;
        if (root != null) stack.push(root);
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            count += path(node, sum);
            if (node.left != null) stack.push(node.left);
            if (node.right != null) stack.push(node.right);
        }
        return count;
    }
}
