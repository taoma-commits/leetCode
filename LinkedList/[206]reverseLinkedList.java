class Solution {
  public ListNode reverseList(ListNode head) {
    ListNode P = null;
    ListNode C = head;
    while (C != null) {
      ListNode N = C.next;
      C.next = P;
      P = C;
      C = N;
    }
    return P;
  }
}

/**
 * performance: 0 ms < 100%
 * time complexity: O(n)
 * space complexity: O(1)
 * notes: iterative. 
 */

class Solution {
  public ListNode reverseList(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode p = reverseList(head.next);
    head.next.next = head;
    head.next = null;
    return p;
  }
}

/**
 * same
 * notes: recusive. 
 */
