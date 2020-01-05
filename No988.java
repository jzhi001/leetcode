import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class No988 {
    public String smallestFromLeaf(TreeNode root) {
        if(root == null) return null;

        List<String> list = new ArrayList<>();
        preOrder(root, "", list);
        Collections.sort(list);

        return list.get(0);
    }

    public void preOrder(TreeNode node, String cur, List<String> list){
        cur = (char)('a' + node.val) + cur;
        if(node.left == null && node.right == null){
            list.add(cur);
            return;
        }

        if(node.left != null) preOrder(node.left, cur, list);
        if(node.right != null) preOrder(node.right, cur, list);
    }
}
