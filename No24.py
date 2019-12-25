# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def swapPairs(self, head):
        
        def recur(node):
            if not node:
                return None
            rt = node.next
            if not rt:
                return node
            node.next = rt.next
            rt.next = node
            node.next = recur(node.next)
            return rt
        
        dummy = ListNode(-1)
        dummy.next = head
        dummy.next = recur(dummy.next)
        return dummy.next
    
        
        
