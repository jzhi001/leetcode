# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    headprev = tailnext = None
    def reverseKGroup(self, head, k):
        
        def mvk(head, k):
            n = 1
            while n < k:
                if not head:
                    return None
                head = head.next
                n += 1
            else:
                return head
        
        def reverse(head, last):
            if head is last:
                return head
            rt = reverse(head.next, last)
            rt.next = head
            return head
            
        
        dummy = ListNode(-1)
        dummy.next = head
        
        headprev = dummy
        
        while True:
            last = mvk(head, k) # if can mov k-1 steps return the last node else return None
            if not last:
                break
            #what looks like now: head -> n1 -> n2 -> last
            #head and last is saved for linking to prev and next nodes
            tailnext = last.next
            reverse(head, last)  # head -> n -> last will change to head <- n <- last
            headprev.next = last # link to prev part
            head.next = tailnext 
            headprev = head
            head = tailnext

        return dummy.next
        
