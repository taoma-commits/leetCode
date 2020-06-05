class Solution {
  List<List<Integer>> res = new ArrayList<>();
  int height = 0;
  public List<List<Integer>> levelOrderBottom(TreeNode root) {
    if (root != null) {
      helper(root);
      Collections.reverse(res);
    }
    return res;
  }
  private void helper(TreeNode node) {
    if (height > res.size() - 1) {
      res.add(new ArrayList<Integer>());
    }
    res.get(height).add(node.val);
    height++;
    if (node.left != null) {
      helper(node.left);
    }
    if (node.right != null) {
      helper(node.right);
    }
    height--;
  }
}

/**
 * performance: 1 ms < 99%
 * time complexity: O(n)
 * space complexity: O(n)
 * notes: recursion + reverse list.
 */

 class Solution {
  List<List<Integer>> res = new ArrayList<>();
  int height = 0;
  public List<List<Integer>> levelOrderBottom(TreeNode root) {
    if (root != null) helper(root);
    return res;
  }
  private void helper(TreeNode node) {
    if (height > res.size() - 1) {
      res.add(0, new ArrayList<Integer>());
    }
    res.get(res.size() - height - 1).add(node.val);
    height++;
    if (node.left != null) {
      helper(node.left);
    }
    if (node.right != null) {
      helper(node.right);
    }
    height--;
  }
}

/**
 * same
 * notes: avoid reverse list by inserting in front. 
 */

 class Solution {
   public List<List<Integer>> levelOrderBottom(TreeNode root) {
     List<List<Integer>> res = new ArrayList<>();
     if (root != null) {
       Deque<TreeNode> dq = new ArrayDeque<>();
       dq.addLast(root);
       while (!dq.isEmpty()) {
         List<Integer> level = new ArrayList<>();
         int len = dq.size(); // the size will be changing in the following loop
         for (int i = 0; i < len; i++) {
           TreeNode node = dq.removeFirst();
           level.add(node.val);
           if (node.left != null) dq.addLast(node.left);
           if (node.right != null) dq.addLast(node.right);
         }
         res.add(0, level);
       }
     }
     return res;
   }
 }

 /**
  * performance: 2 ms < 28%
  * time complexity: O(n)
  * space complexity: O(n)
  */
