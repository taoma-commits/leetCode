class Solution {
  public ListNode reverseBetween(ListNode head, int m, int n) {
    ListNode dummyHead = new ListNode(0);
    dummyHead.next = head;
    ListNode current = dummyHead;
    ListNode prev = null;
    for (int i = 1; i < m + 1; i++) {
      prev = current;
      current = prev.next;
    }
    ListNode leftCut = prev;
    ListNode rightCut = current;
    prev = null;
    for (int i = m; i < n + 1; i++) {
      if (current != null) {ListNode cache = current.next;
        current.next = prev;
        prev = current;
        current = cache;
      }
    }
    if (rightCut != null) rightCut.next = current;
    if (leftCut != null) leftCut.next = prev;
    return dummyHead.next;
  }
}

/**
 * performance: 0 ms < 100%
 * time complexity: O(n);
 * space complexity: O(1);
 */
