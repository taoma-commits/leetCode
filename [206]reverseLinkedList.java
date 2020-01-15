/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Reverse Linked List.
Memory Usage: 37.3 MB, less than 98.56% of Java online submissions for Reverse Linked List.
@linkedList
*/


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode pre = null;
        ListNode node = null;
        while (curr != null) {
            node = curr.next;
            curr.next = pre;
            pre = curr;
            curr = node;
        }
        return pre;
    }
}
