/*
 * @lc app=leetcode id=73 lang=java
 *
 * [73] Set Matrix Zeroes
 */
class Solution {
     public void setZeroes(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return;
        
        int m = matrix.length, n = matrix[0].length;
        
        boolean[] zeroRows = new boolean[m];
        boolean[] zeroCols = new boolean[n];
        
        for(int r = 0; r < m; r++){
            for(int c = 0; c < n; c++){
                if(matrix[r][c] != 0) continue;     
                zeroRows[r] = true;
                zeroCols[c] = true;   
            }
        }
        
        for(int r = 0; r < zeroRows.length; r++){
            if(!zeroRows[r]) continue;
            for(int p = 0; p < n; p++) matrix[r][p] = 0;
        }
        
        for(int c = 0; c < zeroCols.length; c++){
            if(!zeroCols[c]) continue;
            for(int q = 0; q < m; q++) matrix[q][c] = 0;
        }
    }
}

