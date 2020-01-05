import java.util.ArrayList;
import java.util.List;

public class No109 {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;

        List<Integer> list = new ArrayList<>();

        ListNode node = head;
        while(node != null){
            list.add(node.val);
            node = node.next;
        }

        return recur(list, 0, list.size() - 1);
    }

    public TreeNode recur(List<Integer> list, int s, int e){
        if(e < 0 || s >= list.size() || s > e) return null;

        int mid = (s + e) / 2;
        TreeNode node = new TreeNode(list.get(mid));

        node.left = recur(list, s, mid - 1);
        node.right = recur(list, mid + 1, e);

        return node;
    }
}
