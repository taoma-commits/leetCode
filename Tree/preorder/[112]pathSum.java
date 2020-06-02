class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        sum -= root.val;
        if (root.left == null && root.right == null) {
            return sum == 0;
        }
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }
}

/**
 * performance: 0 ms < 100%
 * time complexity: O(n)
 * space complexity: O(depth)
 * notes: recursion.
 */

 class Solution {
   public boolean hasPathSum(TreeNode root, int sum) {
     if (root == null) return false;
     Deque<TreeNode> dq = new ArrayDeque<>();
     Deque<Integer> scores = new ArrayDeque<>();
     dq.addLast(root);
     scores.addLast(sum - root.val);
     while (!dq.isEmpty()) {
       TreeNode node = dq.removeLast();
       int score = scores.removeLast();
       if (node.left == null && node.right == null && score == 0) {
         return true;
       }
       if (node.right != null) {
         dq.addLast(node.right);
         scores.addLast(score - node.right.val);
       }
       if (node.left != null) {
         dq.addLast(node.left);
         scores.addLast(score - node.left.val);
       }
     }
     return false;
   }
 }

 /**
  * performance: 2 ms < 10%
  * time complexity: O(n)
  * space complexity: O(depth)
  * notes: iteration with double stacks.
  */
