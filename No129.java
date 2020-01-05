public class No129 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        return postOrder(root, 0);
    }

    public int postOrder(TreeNode node, int cur) {
        cur = cur * 10 + node.val;
        if (node.left == null && node.right == null) return cur;
        int sum = 0;

        if (node.left != null) {
            sum += postOrder(node.left, cur);
        }
        if (node.right != null) {
            sum += postOrder(node.right, cur);
        }

        return sum;
    }
}
