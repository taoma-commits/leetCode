class Solution {
  ListNode Head;
  public TreeNode sortedListToBST(ListNode head) {
    Head = head;
    int len = 0;
    while (head != null) {
      len++;
      head = head.next;
    }
    return helper(0, len - 1);
  }


  private TreeNode helper(int lo, int hi) {
    if (lo > hi) return null;
    int mid = (lo + hi + 1) >> 1;
    TreeNode left = helper(lo, mid - 1);
    TreeNode node = new TreeNode(Head.val);
    node.left = left;
    Head = Head.next;
    node.right = helper(mid + 1, hi);
    return node;
  }
}

/**
 * performance: 0 ms < 100%
 * time complexity: O(n)
 * space complexity: O(log(n)) not counting the output.
 * notes: in-order traversal simulation.
 */



class Solution {
  public TreeNode sortedListToBST(ListNode head) {
    if (head == null) return null;
    List<Integer> list = new ArrayList<>();
    while (head != null) {
      list.add(head.val);
      head = head.next;
    }
    return helper(list, 0, list.size() - 1);
  }

  private TreeNode helper(List<Integer> list, int lo, int hi) {
    int idx = 1 + (lo + hi) >> 1;
    TreeNode root = new TreeNode(list.get(idx));
    if (lo <= idx - 1) root.left = helper(list, lo, idx - 1);
    if (hi >= idx + 1) root.right = helper(list, idx + 1, hi);
    return root;
  }
}

/**
 * performance: 2 ms < 27%
 * time complexity: O(n)
 * space complexity: O(n)
 * notes: convert linkedlist to arraylist.
 */
