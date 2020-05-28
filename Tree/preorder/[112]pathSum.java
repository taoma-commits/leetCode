/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Path Sum.
Memory Usage: 43.3 MB, less than 5.88% of Java online submissions for Path Sum.
*/

/*
* Note: a path must terminates at a leaf.
*/

class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        sum -= root.val;
        if (root.left == null && root.right == null) return sum == 0;
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }
}
