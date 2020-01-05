public class No108 {
    public TreeNode sortedArrayToBST(int[] A) {
        if(A == null || A.length == 0) return null;

        return recur(A, 0, A.length - 1);
    }

    public TreeNode recur(int[] A, int s, int e){
        if(s >= A.length || e < 0 || s > e) return null;

        int mid = (s + e) / 2;

        TreeNode node = new TreeNode(A[mid]);
        node.left = recur(A, s, mid - 1);
        node.right = recur(A, mid + 1, e);

        return node;
    }
}
