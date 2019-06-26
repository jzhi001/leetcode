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

        for(int r = 0; r <= src.length(); r++){
            for(int c = 0; c <= dest.length(); c++){
                if(r == 0 && c == 0) grid[r][c] = 0;
                else if(r == 0) grid[r][c] = c;
                else if(c == 0) grid[r][c] = r;
                else if(src.charAt(r - 1) == dest.charAt(c - 1)) grid[r][c] = grid[r-1][c-1];
                else{
                    int tmp = Math.min(grid[r-1][c-1], grid[r-1][c]);
                    grid[r][c] = Math.min(tmp, grid[r][c-1]) + 1;
                }
            }
        }

        return grid[src.length()][dest.length()];
    }
}

