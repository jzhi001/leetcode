# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def isSymmetric(self, root):
        
        def same(a, b):
            if (not a) and (not b):
                return True
            elif a and b:
                return a.val == b.val and same(a.left, b.right) and same(a.right, b.left)
            else:
                return False
            
        if not root:
            return True
        return same(root.left, root.right)
        
