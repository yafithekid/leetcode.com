# Definition for singly-linked list.
#class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    # @param head, a ListNode
    # @return a ListNode
    def deleteDuplicates(self, head):
        if (head == None):
        	return None
        elif (head.next == None):
        	return ListNode(head.val)
        elif (head.next != None and head.next.val == head.val):
        	return self.deleteDuplicates(head.next)
        else:
        	retval = ListNode(head.val)
        	retval.next = self.deleteDuplicates(head.next)
        	return retval