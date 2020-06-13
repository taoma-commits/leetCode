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
