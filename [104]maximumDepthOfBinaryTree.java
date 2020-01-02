/*
* Runtime: 0 ms, faster than 100.00% of Java online submissions for Maximum Depth of Binary Tree.
* Memory Usage: 38.3 MB, less than 97.85% of Java online submissions for Maximum Depth of Binary Tree.
*/

class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int max = Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        return max;
    }
}
