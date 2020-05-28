class Solution {
  public ListNode oddEvenList(ListNode head) {
    ListNode odd = new ListNode(-1);
    ListNode even = new ListNode(-1);
    odd.next = even;
    even.next = head;
    ListNode firstNode = odd;
    ListNode secondNode = even;
    while (secondNode.next != null) {
      firstNode.next = secondNode.next;
      firstNode = firstNode.next;
      if (firstNode.next == null) {
        secondNode.next = null;
      } else {
        secondNode.next = secondNode.next.next;
        secondNode = secondNode.next;
      }
    }
    firstNode.next = even.next;
    return odd.next;
  }
}

/**
 * performance: 0 ms < 100%
 * time complexity: O(n)
 * space complexity: O(1)
 * notes: dummy head trick.
 */
