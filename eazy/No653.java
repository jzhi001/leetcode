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
    
    private boolean flag = false;
    private int tar = 0;
    private Set<Integer> set = new HashSet<>();
    
    public boolean findTarget(TreeNode root, int k) {
        if(root == null || ( (root.left == root.right) && (root.left == null) )) return false;
        tar = k;
        sub(root);
        
        return flag;
    }
    void sub(TreeNode node){
        if(set.contains(tar - node.val))
            flag = true;
        else
            set.add(node.val);
        if(flag) return;
        if(node.left != null)
            sub(node.left);
        if(node.right != null)
            sub(node.right);
    }
}