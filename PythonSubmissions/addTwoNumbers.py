# Definition for singly-linked list.

class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution(object):

    def addTwoNumbers(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        if l1 == None and l2 == None:
            return None
        elif l1 == None:
            return l2
        elif l2 == None:
            return l1
        else:
            Sum = l1.val + l2.val
            nextNode = self.addTwoNumbers(l1.next, l2.next)
            currentNode = ListNode(Sum % 10)
            if Sum >= 10:
                if nextNode == None:
                    nextNode = ListNode(1)
                else:
                    nextNode = self.addTwoNumbers(ListNode(1), nextNode)
            currentNode.next = nextNode
            return currentNode
            
