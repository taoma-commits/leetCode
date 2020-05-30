class Solution {
  List<Integer> res = new ArrayList<>();
  public List<Integer> postorderTraversal(TreeNode root) {
    if (root != null) {
      if (root.left != null) {
        postorderTraversal(root.left);
      }
      if (root.right != null) {
        postorderTraversal(root.right);
      }
      res.add(root.val);
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
 
