class Solution {
  public void flatten(TreeNode root) {
    if (root == null) return;
    flatten(root.right);
    if (root.left != null) {
      TreeNode R = root.right;
      flatten(root.left);
      root.right = root.left;
      root.left = null;
      while(root.right != null) {
        root = root.right;
      }
      root.right = R;
    }
  }
}

/**
 * performance: 0 ms < 100%
 * time complexity: O(n)
 * space complexity: O(h)
 * notes: recursion
 */

 class Solution {
   public void flatten(TreeNode root) {
     while (root != null) {
       if (root.left != null) {
         TreeNode rootRight = root.left;
         TreeNode pred = root.left;
         while (pred.right != null) {
           pred = pred.right;
         }
         pred.right = root.right;
         root.right = rootRight;
         root.left = null;
       }
       root = root.right;
     }
   }
 }

 /**
  * performance: 0 ms < 100%
  * time complexity: O(n)
  * space complexity: O(1)
  * notes: Morris-traversal-like 
  */
