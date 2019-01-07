/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//can be improved by
//TreeNode right = invertTree(root.right);
//TreeNode left = invertTree(root.left);
//root.left = right;
//root.right = left;
//return root;


//not accually a recursion!!!
class Solution {
    public TreeNode invertTree(TreeNode node) {
        if(node == null)
            return node;
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
        
        invertTree(node.left);
        invertTree(node.right);
        
        return node;
    }
}