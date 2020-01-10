/*
Runtime: 2 ms, faster than 67.54% of Java online submissions for Add Two Numbers.
Memory Usage: 44.9 MB, less than 85.58% of Java online submissions for Add Two Numbers.
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

// instantiate ListNode: new ListNode(int x);
// l3 handle 
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(0);
        ListNode node = l3;
        int sum, carry;
        sum = carry = 0;
        while (l1 != null || l2 != null) {
            int x = (l1 == null)? 0 : l1.val;
            int y = (l2 == null)? 0 : l2.val;
            sum = x + y + carry;
            carry = (sum >= 10)? 1 : 0;
            node.next = new ListNode(sum % 10);
            node = node.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry != 0) node.next = new ListNode(carry);
        return l3.next;
    }
}
