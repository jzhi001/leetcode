/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//can be improved by one-method recursion
//but I don't fucking understand!!

class Solution {
    
     int L;
     int R;
     TreeNode result;
    TreeNode now;
     List<Integer> arr = new ArrayList<>();
    
    public TreeNode trimBST(TreeNode root, int L, int R) {
        this.L = L;
        this.R = R;
        
        search(root);
        
        for(int each : arr){
            if(result == null)
                result = new TreeNode(each);
            else
                place(each);
        }
        return result;
    }
    void search(TreeNode node){
        if(node == null)    return;
        if(between(node.val))
            arr.add(node.val);
        search(node.left);
        search(node.right);
    }
    void place(int n){
        TreeNode now = result;
        TreeNode parent = result;
        while(now != null){
            now = n > parent.val ? now.right : now.left;
            parent = now == null ? parent : now;
        }
        TreeNode temp = new TreeNode(n);
        if(n < parent.val)
            parent.left = temp;
        else
            parent.right = temp;
    }
    
    boolean between(int n){
        return n >= L && n <= R;
    }
}