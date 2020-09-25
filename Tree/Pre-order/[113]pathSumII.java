class Solution {
  List<List<Integer>> res = new ArrayList<>();
  List<Integer> path = new ArrayList<>();
  int S;
  public List<List<Integer>> pathSum(TreeNode root, int sum) {
    S = sum;
    if (root != null) {
      backtrack(root);
    }
    return res;
  }

  private void backtrack(TreeNode node) {
    S -= node.val;
    path.add(node.val);
    if (node.left == null && node.right == null && S == 0) {
      res.add(new ArrayList<Integer>(path));
    } else {
      if (node.left != null) {
        backtrack(node.left);
      }
      if (node.right != null) {
        backtrack(node.right);
      }
    }
    S += node.val;
    path.remove(path.size() - 1);
  }
}

/**
 * performance: 1 ms < 100%
 * time complexity: O(n)
 * space complexity: O(depth)
 * notes: recursion; backtracking. 
 */
