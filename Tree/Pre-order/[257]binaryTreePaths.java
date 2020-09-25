class Solution {
  List<String> res = new ArrayList<>();
  public List<String> binaryTreePaths(TreeNode root) {
    if (root != null) {
      helper(root, new StringBuilder());
    }
    return res;
  }

  private void helper(TreeNode node, StringBuilder path) {
    path.append(node.val);
    if (node.left == null && node.right == null) {
      res.add(path.toString());
    } else {
      path.append("->");
      int len = path.length();
      if (node.left != null) {
        helper(node.left, path);
        path.setLength(len);
      }
      if (node.right != null) {
        helper(node.right, path);
      }
    }
  }
}

/**
 * performance: 1 ms < 100%
 * time complexity: O(n)
 * space complexity: O(depth)
 * notes: recursion.
 */
 
class Solution {
  public List<String> binaryTreePaths(TreeNode root) {
    List<String> res = new ArrayList<>();
    if (root == null) return res;
    Deque<TreeNode> dq = new ArrayDeque<>();
    Deque<String> paths = new ArrayDeque<>();
    dq.addLast(root);
    paths.addLast("");
    while (!dq.isEmpty()) {
      TreeNode node = dq.removeFirst();
      String s = paths.removeFirst();
      s = s + node.val;
      if (node.left == null && node.right == null) {
        res.add(s);
      } else {
        if (node.right != null) {
          dq.addLast(node.right);
          paths.addLast(s + "->");
        }
        if (node.left != null) {
          dq.addLast(node.left);
          paths.addLast(s + "->");
        }
      }
    }
    return res;
  }
}

/**
 * performance: 15 ms < 15%
 * time complexity: O(n)
 * sapce complexity: O(depth)
 */
