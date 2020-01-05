import java.util.HashMap;
import java.util.Map;

public class No1302 {
    public int deepestLeavesSum(TreeNode root) {
        if(root == null) return 0;

        Map<Integer, Integer> map = new HashMap<>();

        dfs(root, 1, map);

        int level = 0;
        int result = 0;

        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            int lv = entry.getKey();
            if(lv > level){
                level = lv;
                result = entry.getValue();
            }
        }

        return result;
    }

    public void dfs(TreeNode node, int level, Map<Integer, Integer> map){
        int cur = map.containsKey(level) ? map.get(level) : 0;
        cur += node.val;
        map.put(level, cur);

        if(node.left != null) dfs(node.left, level+1, map);
        if(node.right != null) dfs(node.right, level+1, map);

    }
}
