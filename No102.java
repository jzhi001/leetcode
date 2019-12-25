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
   List<List<Integer>> ret = new ArrayList<>();
    
    /**
     * @param root: A Tree
     * @return: Level order a list of lists of integer
     */
    public List<List<Integer>> levelOrder(TreeNode rt) {
        if(rt == null) return ret;
        
        b(rt, 0);
        
        return ret;
    }
    
    void b(TreeNode n, int lv){
        if(ret.size() <= lv ) ret.add(new ArrayList<Integer>() );
        ret.get(lv).add(n.val);
        if(n.left != null) b(n.left, lv+1);
        if(n.right != null) b(n.right, lv+1);
    }
}
