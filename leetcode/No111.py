# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def minDepth(self, root):
        if not root:
            return 0
        L, R = self.minDepth(root.left), self.minDepth(root.right)
        if L == 0 and R == 0:
            return 1
        elif L == 0:
            return 1 + R
        elif R == 0:
            return 1 + L
        else:
            return 1 + min(L, R)
        
