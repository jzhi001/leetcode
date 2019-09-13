/*
 * @lc app=leetcode id=74 lang=java
 *
 * [74] Search a 2D Matrix
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) return false;
        
        int R = matrix.length, C = matrix[0].length;
        int lf = 0, rt = R * C - 1; 
        
        while(lf <= rt && lf <= (R * C - 1)){
            int mid = (lf + rt) / 2;  
            // System.out.println(mid);
            int r = mid / C;
            int c = mid % C;
            // System.out.printf("%d %d\n", r, c);
            int x = matrix[r][c];
            if(x == target) return true;
            else if(x > target) rt = mid - 1;
            else lf = mid + 1;
        }
        return false;
    }
}

