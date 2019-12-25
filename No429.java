/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    List<List<Integer>> ret = new ArrayList<>();
    
    public List<List<Integer>> levelOrder(Node rt) {
        r(rt, 0);
        return ret;
    }
    
    void r(Node n, int lv){
        if(n == null) return;
        if(ret.size() <= lv) ret.add(new ArrayList<Integer>());
        
        ret.get(lv).add(n.val);
        
        for(Node c : n.children){
            r(c, lv+1);
        }
    }
}
