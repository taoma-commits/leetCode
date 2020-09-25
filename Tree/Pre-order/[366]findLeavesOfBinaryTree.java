class Solution {
  List<List<Integer>> res = new ArrayList<>();
  public List<List<Integer>> findLeaves(TreeNode root) {
    helper(root);
    return res;
  }
  private int helper(TreeNode node) {
    if (node == null) return -1;
    int height = 1 + Math.max(helper(node.left), helper(node.right));
    if (height > res.size() - 1) {
      res.add(new ArrayList<Integer>());
    }
    res.get(height).add(node.val);
    return height;
  }
}

/**
 * performance: 0 ms < 100%
 * time complexity: O(n)
 * space complexity: O(n)
 * notes: bottom-up post-order traversal
 */

class Solution {
  List<List<Integer>> res = new ArrayList<>();
  List<Integer> leaves = new ArrayList<>();
  public List<List<Integer>> findLeaves(TreeNode root) {
    if (root == null) return res;
    while (!isLeaf(root)) {
      res.add(new ArrayList<Integer>(leaves));
      leaves.clear();
    }
    res.add(leaves);
    return res;
  }
  private boolean isLeaf (TreeNode node) {
    if (node.left == null && node.right == null) {
      leaves.add(node.val);
      return true;
    }
    if (node.left != null && isLeaf(node.left)) node.left = null;
    if (node.right != null && isLeaf(node.right)) node.right = null;
    return false;
  }
}

/**
 * performance: 0 ms < 100%
 * time complexity: O(n^2)
 * space complexity: O(n)
 * notes: post-order traversal 
 */
