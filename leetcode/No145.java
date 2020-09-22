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
    List<Integer> ret = new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode rt) {
        post(rt);
        return ret;
    }
    
    void post(TreeNode n){
        if(n == null) return;
        post(n.left);
        post(n.right);
        ret.add(n.val);
    }
}
