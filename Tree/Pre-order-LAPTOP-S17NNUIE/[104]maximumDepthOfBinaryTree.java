class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int max = Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        return max;
    }
}

/**
 * performance: 0 ms
 * time complexity: O(n)
 * space complexity: O(max depth)
 */


 class Solution {
   int max = 0;
   int depth = 0;
   public int maxDepth(TreeNode root) {
     Deque<TreeNode> dq = new ArrayDeque<>();
     Deque<Integer> depth = new ArrayDeque<>();
     if (root != null) {
       dq.addLast(root);
       depth.addLast(1);
       while (!dq.isEmpty()) {
         TreeNode node = dq.removeLast();
         int d = depth.removeLast();
         if (node.left == null && node.right == null) {
           max = Math.max(max, d);
         }
         if (node.right != null) {
           dq.addLast(node.right);
           depth.addLast(d + 1);
         }
         if (node.left != null) {
           dq.addLast(node.left);
           depth.addLast(d + 1);
         }
       }
     }
     return max;
   }
 }

 /**
  * performance: 3 ms < 6%
  * time complexity: O(n)
  * space complexity: O(depth)
  */
