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
