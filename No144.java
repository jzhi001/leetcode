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
   public List<Integer> preorderTraversal(TreeNode rt) {
        List<Integer> ret = new ArrayList<>();
        
        pre(rt, ret);
        
        return ret;
    }
    
    void pre(TreeNode n, List<Integer> list){
        if(n == null) return;
        list.add(n.val);
        pre(n.left, list);
        pre(n.right, list);
    }
}
