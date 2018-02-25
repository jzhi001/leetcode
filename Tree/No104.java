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
    public int maxDepth(TreeNode n) {
        if(n == null)   return 0;
        return 1 + Math.max(s(n.left) , s(n.right));
    }
}