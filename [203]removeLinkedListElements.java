/*
Runtime: 1 ms, faster than 97.92% of Java online submissions for Remove Linked List Elements.
Memory Usage: 40.2 MB, less than 98.41% of Java online submissions for Remove Linked List Elements.
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
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        ListNode curr = head;
        while (curr != null) {
            if (curr.val == val) pre.next = curr.next;
            else pre = curr;
            curr = curr.next;
        }
        return dummyHead.next;
    }
}
