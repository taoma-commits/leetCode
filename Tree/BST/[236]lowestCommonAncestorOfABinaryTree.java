class Solution {
  TreeNode res = null;
  TreeNode P;
  TreeNode Q;
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    P = p;
    Q = q;
    helper(root);
    return res;
  }
  private boolean helper(TreeNode node) {
    if (node == null) return false;
    if (res != null) return false;
    boolean L = helper(node.left);
    boolean R = helper(node.right);
    if (L || R) {
      if ((L && R) || node == P || node == Q) res = node;
      return true;
    } else {
      return (node == P || node == Q);
    }
  }
}
/**
 * performance: 7 ms < 99%
 * time complexity: O(n)
 * space complexity: O(depth)
 * notes: early stop DFS if answer is found.
 */

class Solution {
  Map<Integer, TreeNode> map = new HashMap<>();
  Set<Integer> set = new HashSet<>();

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    dfs(root);
    while (map.containsKey(p.val)) {
      set.add(p.val);
      p = map.get(p.val);
    }
    while (map.containsKey(q.val)) {
      if (set.contains(q.val)) return q;
      q = map.get(q.val);
    }
    return q;
  }
  private void dfs(TreeNode node) {
    if (node.left != null) {
      map.put(node.left.val, node);
      dfs(node.left);
    }
    if (node.right != null) {
      map.put(node.right.val, node);
      dfs(node.right);
    }
  }
}

/**
 * performance: 13 ms < 16%
 * time complexity: O(n)
 * space complexity: O(n)
 * notes: store parent nodes. 
 */
