class Solution {
    public int findLength(int[] A, int[] B) {
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
}