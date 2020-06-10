class Solution {
  public List<Integer> rightSideView(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    if (root == null) return res;
    LinkedList<TreeNode> dq = new LinkedList<>();
    dq.addLast(root);
    dq.addLast(null);
    while (!dq.isEmpty()) {
      TreeNode node = dq.removeFirst();
      if (node == null) {
        if (!dq.isEmpty()) dq.addLast(null);
      } else {
        if (dq.getFirst() == null) {
          res.add(node.val);
        }
        if (node.left != null) dq.addLast(node.left);
        if (node.right != null) dq.addLast(node.right);
      }
    }
    return res;
  }
}

/**
 * performance: 1 ms < 95%
 * time complexity: O(n)
 * space complexity: O(n)
 * notes: delimiter BFS
 */

 class Solution {
   Map<Integer, Integer> map = new HashMap<>();
   int height = 0;
   int depth = 0;
   public List<Integer> rightSideView(TreeNode root) {
     List<Integer> res = new ArrayList<>();
     if (root != null) {
       helper(root);
       for (int i = 0; i < depth + 1; i++) {
         res.add(map.get(i));
       }
     }
     return res;
   }
   private void helper(TreeNode node) {
     map.put(height, node.val);
     height++;
     if (node.left != null) {
       depth = Math.max(depth, height);
       helper(node.left);
     }
     if (node.right != null) {
       depth = Math.max(depth, height);
       helper(node.right);
     }
     height--;
   }
 }

 /**
  * same
  * space complexity: O(depth)
  * notes: DFS
  */
