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
    private List<Integer> result = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode n) {
        if(n == null) return result;
        inorderTraversal(n.left);
        result.add(n.val);
        inorderTraversal(n.right);
        return result;
    }
    
}
