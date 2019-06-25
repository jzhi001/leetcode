/*
 * @lc app=leetcode id=72 lang=java
 *
 * [72] Edit Distance
 */
class Solution {
    public int minDistance(String src, String dest) {
        if(src == null || dest == null) return 0;

        int[][] grid = new int[src.length() + 1][dest.length() + 1];

        grid[0][0] = 0;
    }
}

