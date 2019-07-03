/* * @lc app=leetcode id=44 lang=java * 
* [44] Wildcard Matching */
class Solution {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null)
            return false;
        boolean[][] grid = new boolean[p.length() + 1][s.length() + 1];
        grid[0][0] = true;
        for (int i = 1; i <= s.length(); i++)
            grid[0][i] = false;
        if (p.length() > 0 && p.charAt(0) == '*')
            grid[1][0] = true;
        for (int i = 2; i <= p.length(); i++)
            grid[i][0] = grid[i - 1][0] && (p.charAt(i - 1) == '*');
        for (int r = 1; r <= p.length(); r++) {
            for (int c = 1; c <= s.length(); c++) {
                boolean ret = false;
                char cp = p.charAt(r - 1), cs = s.charAt(c - 1);
                if (grid[r - 1][c - 1]) {
                    ret = (cp == '*') || (cp == '?') || (cp == cs);
                }
                if (!ret && grid[r - 1][c]) {
                    ret = cp == '*';
                }
                if (!ret && grid[r][c - 1]) {
                    ret = cp == '*';
                }
                grid[r][c] = ret;
            }
        }
        return grid[p.length()][s.length()];
    }
}