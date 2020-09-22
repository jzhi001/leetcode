# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

from queue import Queue

class Solution:
    def zigzagLevelOrder(self, root):
        if not root:
            return []
        
        arr, result = [], []
        q = Queue()
        prevWay, L = True, True
        
        node = root
        q.put( (node, L) )
        
        while not q.empty():
            n, way = q.get()
            x = n.val
            #new level
            if way != prevWay: 
                if prevWay != L:
                    arr.reverse()
                result.append(arr) 
                arr = [x]
                prevWay = way
            else:
                arr.append(x)
            
            #print(arr)
            #add children
            if n.left:
                q.put( (n.left, not way) )
            if n.right:
                q.put( (n.right, not way) )
        
        if prevWay != L:
            arr.reverse()
        result.append(arr)
        return result
            
        
