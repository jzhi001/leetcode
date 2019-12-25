# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def pathSum(self, root, sum):
        
        def recur(node, x):
            if (not node.left) and (not node.right): #leaf
                result = [] if x != node.val else [ [node.val] ]
                return result
            result = []
            if node.left:
                L = recur(node.left, x - node.val)
                if L:
                    result += L
            if node.right:
                R = recur(node.right, x - node.val)
                if R:
                    result += R
            for x in result:
                x.insert(0, node.val)
            return result
        if not root :
            return []
        return recur(root, sum)
            
        
