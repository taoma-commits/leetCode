class Solution {
  List<List<Integer>> res = new ArrayList<>();
  int height = 0;
  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    if (root != null) {
      helper(root);
    }
    return res;
  }
  private void helper(TreeNode node) {
    if (height > res.size() - 1) res.add(new LinkedList<Integer>());
    if ((height & 1) == 0) {
      res.get(height).add(node.val);
    } else {
      res.get(height).add(0, node.val);
    }
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
 * performance: 1 ms < 98%
 * time complexity: O(n)
 * space complexity: O(depth) not counting output;
 * notes: DFS
 */

 class Solution {
   public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
     List<List<Integer>> res = new ArrayList<>();
     if (root == null) return res;
     boolean reverse = false;
     LinkedList<Integer> level = new LinkedList<>();
     Deque<TreeNode> dq = new LinkedList<>();
     dq.addLast(root);
     dq.addLast(null);
     while (!dq.isEmpty()) {
       TreeNode node = dq.removeFirst();
       if (node == null) {
         res.add(new ArrayList<Integer>(level));
         level.clear();
         reverse = !reverse;
         if (!dq.isEmpty()) dq.addLast(null);
       } else {
         if (reverse) {
           level.addFirst(node.val);
         } else {
           level.addLast(node.val);
         }
         if (node.left != null) dq.addLast(node.left);
         if (node.right != null) dq.addLast(node.right);
       }
     }
     return res;
   }
 }

 /**
  * same
  * space complexity: O(n).
  * notes: delimiter BFS.
  */

  class Solution {
   public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
     List<List<Integer>> res = new ArrayList<>();
     if (root == null) return res;
     boolean reverse = false;
     Deque<TreeNode> dq1 = new ArrayDeque<>();
     Deque<TreeNode> dq2 = new ArrayDeque<>();
     dq1.addLast(root);
     while (!dq1.isEmpty()) {
       LinkedList<Integer> level = new LinkedList<>();
       while (!dq1.isEmpty()) {
         TreeNode node = dq1.removeFirst();
         if (reverse) {
           level.addFirst(node.val);
         } else {
           level.addLast(node.val);
         }
         dq2.addLast(node);
       }
       res.add(level);
       reverse = !reverse;
       while (!dq2.isEmpty()) {
         TreeNode node = dq2.removeFirst();
         if (node.left != null) dq1.addLast(node.left);
         if (node.right != null) dq1.addLast(node.right);
       }
     }
     return res;
   }
 }

/**
 * same
 * space complexity: O(n)
 * notes: double queues BFS.
 */
