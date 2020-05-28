class Solution {
  public ListNode swapPairs(ListNode head) {
    ListNode dummy = new ListNode(-1);
    dummy.next = head;
    ListNode prevNode = dummy;
    ListNode currentNode = head;
    while (currentNode != null && currentNode.next != null) {
      ListNode cache = currentNode.next.next;
      currentNode.next.next = currentNode;
      prevNode.next = currentNode.next;
      prevNode = currentNode;
      prevNode.next = cache;
      currentNode = cache;
    }
    return dummy.next;
  }
}

/**
 * performance: 0 ms < 100%
 * time complexity: O(n)
 * space complexity: O(1)
 * notes: iteration; dummy head trick. 
 */
 
class Solution {
  public ListNode swapPairs(ListNode head) {
    if (head != null) {
      ListNode next = head.next;
      if (next != null) {
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
      }
    }
    return head;
  }
}

/**
 * performance: 0 ms < 100%
 * time complexity: O(n)
 * space complexity: O(n)! Store recursion stack.
 * notes: recursion.
 */
