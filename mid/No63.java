class Solution {
    public int uniquePathsWithObstacles(int[][] o) {
        if(o == null || o.length ==0 ) return 0;
        int R = o.length, C = o[0].length;
        
        int[][] m = new int[R][C];
        m[0][0] = o[0][0] == 1 ? 0 : 1;
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(i == 0 && j == 0) continue;
                if( o[i][j] == 1){
                    m[i][j] = 0;
                }else{
                    int up = 0, lf = 0;
                    if(i > 0) up = m[i-1][j];
                    if(j > 0) lf = m[i][j-1];
                    m[i][j] = up + lf;   
                }
            }
        }
        return m[R-1][C-1];
    }
}
