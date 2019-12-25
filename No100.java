/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null)
            return true;
        boolean result = false;
        
        if( p != null && q != null && p.val == q.val)
            result = true;
        
        result = result && isSameTree(p.left, q.left);
        result = result && isSameTree(p.right, q.right);
        
        return result;
    }
}