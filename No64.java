public class Solution {
    /**
     * @param grid: a list of lists of integers
     * @return: An integer, minimizes the sum of all numbers along its path
     */
    public int minPathSum(int[][] A) {
        if(A == null || A.length == 0) return 0;
        int R = A.length, C = A[0].length;
        int[][] m = new int[R][C];
        m[0][0] = A[0][0];
        
        for(int i=1; i<R; i++) m[i][0] = A[i][0] + m[i-1][0];
        for(int i=1; i<C; i++) m[0][i] = A[0][i] + m[0][i-1];
        
        for(int i=1; i<R; i++){
            for(int j=1; j<C; j++){
                if(i == 0 && j == 0) continue;
                int up = m[i-1][j], lf = m[i][j-1];
                m[i][j] = A[i][j] + Math.min(up, lf);
            }
        }
        
        return m[R-1][C-1];
    }
}
