public class Solution {
  public boolean hasCycle(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) return true;
    }
    return false;
  }
}
/**
 * performance: 0 ms < 100% 
 * time complexity: O(n)
 * space complexity: O(1)
 */
