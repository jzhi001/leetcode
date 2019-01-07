# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def isBalanced(self, root):
        
        def recur(node):
            if not node:
                return (0, 0, True)
            rL, rR = recur(node.left), recur(node.right)
            #print(rL, rR)
            if (not rL[2]) or (not rR[2]):
                return (0, 0, False)
            L = max(rL[0], rL[1])
            R = max(rR[0], rR[1])
            delta = abs(L - R)
            if delta > 1:
                return (-1, -1, False)
            return (1+L, 1+R, True)
        
        return recur(root)[2]
        
