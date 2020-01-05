import java.util.ArrayList;
import java.util.List;

public class No257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        if(root == null) return list;
        recur(root, "", list);
        return list;
    }

    public void recur(TreeNode node, String cur, List<String> list){
        if(!cur.isEmpty()) cur += "->";
        cur += node.val;
        if(node.left == null && node.right == null){
            list.add(cur);
            return;
        }

        if(node.left != null) recur(node.left, cur, list);
        if(node.right != null) recur(node.right, cur, list);
    }
}
