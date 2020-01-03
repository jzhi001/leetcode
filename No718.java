class No718 {
    public int findLength_bruteForce(int[] A, int[] B) {
        if(A == null || B == null) return 0;

        int result = 0;

        for(int i = 0; i < A.length; i++){
            for(int j = 0; j < B.length; j++){
                int n = 0, ia = i, ib = j;
                while(ia < A.length && ib < B.length && A[ia] == B[ib]){
                    ia++;
                    ib++;
                    n++;
                }
                result = Math.max(result, n);
            }
        }

        return result;
    }

    public int findLength_dp(int[] A, int[] B) {
        if(A == null || B == null) return 0;

        int[][] memo = new int[A.length + 1][B.length + 1];

        int result = 0;

        for(int i = A.length - 1; i >= 0; i--){
            for(int j = B.length - 1; j >= 0; j--){
                if(A[i] == B[j]){
                    memo[i][j] = memo[i+1][j+1] + 1;
                }else{
                    memo[i][j] = 0;
                }
                result = Math.max(result, memo[i][j]);
            }
        }

        return result;
    }
}