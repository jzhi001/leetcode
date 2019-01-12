public class Solution {
    /**
     * @param m: positive integer (1 <= m <= 100)
     * @param n: positive integer (1 <= n <= 100)
     * @return: An integer
     */
    public int uniquePaths(int m, int n) {
        if(m <= 0) return 0;
        int[][] a = new int[m][n];
        a[0][0] = 1;
        
        for(int i=1; i<m; i++) a[i][0] = 1;
        for(int i=1; i<n; i++) a[0][i] = 1;
        
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                a[i][j] = a[i-1][j] + a[i][j-1];
            }
        }
        
        return a[m-1][n-1];
    }
}
