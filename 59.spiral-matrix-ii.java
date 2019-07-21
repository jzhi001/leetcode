/*
 * @lc app=leetcode id=59 lang=java
 *
 * [59] Spiral Matrix II
 */
class Solution {
    public int[][] generateMatrix(int n) {
       if(n <= 0) return new int[0][0];
       
       int[][] matrix = new int[n][n];

       int next = 1;
        int level = 0;

       while(next <= n * n){
            for(int c = level; next <= n * n && c < n - level; c++){
                matrix[level][c] = next++;
            }

            for(int r = level + 1; next <= n * n && r < n - level; r++){
                matrix[r][n - level - 1] = next++;
            }

            for(int c = n - level - 2; next <= n * n && c >= level; c--){
                matrix[n - level - 1][c] = next++;
            }

            for(int r = n - level - 2; next <= n * n && r > level; r--){
                matrix[r][level] = next++;
            }
            level++;
       }
        return matrix;
    }
}

