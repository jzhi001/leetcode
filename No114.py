# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def flatten(self, root):
        
        #add all nodes to dummy's right, return the end node
        def recur(node, head):
            if not node:
                return head
            head.right = node
            L, R = node.left, node.right
            node.left = None
            head = recur(L, node)
            return recur(R, head)
            
        
        dummy = TreeNode(1)
        recur(root, dummy)
        
