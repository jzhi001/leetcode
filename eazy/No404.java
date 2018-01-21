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
    public int sumOfLeftLeaves(TreeNode root) {
        return sub(root, false );
    }
    int sub(TreeNode node, boolean isLeft){
         if(node == null)
            return 0;
        if(isLeft && node.left == null && node.right == null )
            return node.val;
        int result = 0;
        result +=  sub(node.left,true) + sub(node.right,false);
        return result;
    }
}