# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def levelOrderBottom(self, root):
        #lv starts from 0
        def recur(node, result, lv):
            if not node:
                return
            newLv = len(result) < lv+1 
            arr = [] if newLv else result[lv]
            arr.append(node.val)
            if newLv:
                result.append(arr)
            recur(node.left, result, lv+1)
            recur(node.right, result, lv+1)
        
        if not root:
            return []
        result = []
        recur(root, result, 0)
        result.reverse()
        return result
        
