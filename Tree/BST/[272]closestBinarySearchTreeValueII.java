class Solution {
  LinkedList<Integer> res;
  double T;
  int K;
  public List<Integer> closestKValues(TreeNode root, double target, int k) {
    res = new LinkedList<>();
    T = target;
    K = k;
    helper(root);
    return res;
  }

  private void helper(TreeNode node) {
    if (node == null) return;
    helper(node.left);
    if (res.size() == K) {
      if (Math.abs(T - res.getFirst()) > Math.abs(T - node.val)) {
        res.removeFirst();
      } else {
        return;
      }
    }
    res.addLast(node.val);
    helper(node.right);
  }
}

/**
 * performance: 0 ms < 100%
 * time complexity: O(n)
 * space complexity: O(n) (recursion stack)
 * notes: In-order traversal + Deque
 */

 class Solution {
   Deque<TreeNode> pre = new ArrayDeque<>();
   Deque<TreeNode> suc = new ArrayDeque<>();
   public List<Integer> closestKValues(TreeNode root, double target, int k) {
     while (root != null) {
       if (root.val < target) {
         pre.addLast(root);
         root = root.right;
       } else {
         suc.addLast(root);
         root = root.left;
       }
     }
     List<Integer> res = new LinkedList<>();
     while (k-- > 0) {
       if (suc.isEmpty() || (!pre.isEmpty() && target - pre.getLast().val < suc.getLast().val - target)) {
         res.add(pre.getLast().val);
         getPredecessor(pre);
       } else {
         res.add(suc.getLast().val);
         getSuccessor(suc);
       }
     }
     return res;
   }

   private void getPredecessor(Deque<TreeNode> pre) {
     TreeNode node = pre.removeLast();
     if (node.left != null) {
       pre.addLast(node.left);
       node = node.left;
       while (node.right != null) {
         pre.addLast(node.right);
         node = node.right;
       }
     }
   }

   private void getSuccessor(Deque<TreeNode> suc) {
     TreeNode node = suc.removeLast();
     if (node.right != null) {
       suc.addLast(node.right);
       node = node.right;
       while (node.left != null) {
         suc.addLast(node.left);
         node = node.left;
       }
     }
   }
 }

/**
 * performance: 2ms < 61%
 * time complexity: O(k + log(n)) ?????
 * space complexity: O(log(n)) ????
 */
