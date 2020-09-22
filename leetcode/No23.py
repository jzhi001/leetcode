# Definition for singly-linked list.
from list_node import ListNode


class Solution:
    def mergeKLists(self, lists):
        h = Heap(lists)
        dummy = ListNode(1)
        curr = dummy
        while not h.empty():
            curr.next = h.pop()
            curr = curr.next
        curr.next = None
        return dummy.next

class Heap:
    def __init__(self, nodelist):
        self.N = len(nodelist) + 1
        pt = 1
        self.size = 0
        self.arr = [None] * self.N
        for node in nodelist:
            self.arr[pt] = node
            if node:
                self.size += 1
            self.swim(pt)
            pt += 1
            
    def swim(self, idx):
        if idx == 1:
            return
        hidx = idx // 2
        if not self.lt(idx, hidx):
            return
        self.swap(hidx, idx)
        self.swim(hidx)
            
        
    def shrink(self, i):
        if i*2 >= self.N:
            return
        #must have at least one child
        ilf = i*2
        irt = -1 if ilf+1>=self.N else ilf+1
        smallest = ilf
        if irt > 0 and self.lt(irt, ilf):
            smallest = irt
        #print('shrink cmp ', smallest, i) 
        if not self.lt(smallest, i):
            return
        self.swap(smallest, i)
        self.shrink(smallest)
        
    def pop(self):
        result = self.arr[1]
        self.arr[1] = self.arr[1].next
        if not self.arr[1]:
            self.size -= 1
        self.shrink(1)
        return result
    
    def empty(self):
        return self.size == 0
    
    def swap(self, ia, ib):
        self.arr[ia], self.arr[ib] = self.arr[ib], self.arr[ia]
        
    #None is the greatest
    def lt(self, ia, ib):
        a, b = self.arr[ia], self.arr[ib]
        if a and b:
            return a.val < b.val
        elif (not a) and (not b):
            return False
        elif not a:
            return False
        else:
            return True
            
        
    
        
