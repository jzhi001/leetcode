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
    public TreeNode insertIntoBST(TreeNode rt, int v) {
        if(rt == null) return new TreeNode(v);
        insert(rt, new TreeNode(v));
        return rt;
    }
    
    void insert(TreeNode p, TreeNode n){
        if(p.val > n.val){
            if(p.left == null) p.left = n;
            else insert(p.left, n);
        }else{
            if(p.right == null) p.right = n;
            else insert(p.right, n);
        }
    }
}
