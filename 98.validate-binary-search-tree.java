/*
 * @lc app=leetcode id=98 lang=java
 *
 * [98] Validate Binary Search Tree
 */
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
    public boolean isValidBST(TreeNode node) {
       if(node == null) return true;
        return dfs(node).ret;

    }

    Tuple dfs(TreeNode node){
        Tuple lf = node.left == null ? null : dfs(node.left);
        Tuple rt = node.right == null ? null : dfs(node.right);

        boolean ret = true;
        int min = node.val, max = node.val;

        if(lf != null){
            min = lf.min;
            ret &= lf.ret;
            ret &= lf.max < node.val;
        }

        if(rt != null){
            max = rt.max;
            ret &= rt.ret;
            ret &= node.val < rt.min;
        }
        return new Tuple(min, max, ret);
    }

    static class Tuple{
        int min;
        int max;
        boolean ret = true;

        Tuple(int min, int max, boolean ret){
            this.min = min;
            this.max = max;
            this.ret = ret;
        }
    }
}

