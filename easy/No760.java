class Solution {
    public int[] anagramMappings(int[] A, int[] B) {
        if(A.length == 0)   return new int[0];
        int[] result = new int[A.length];
        for(int i=0; i<A.length; i++){
            for(int j=0;j<B.length;j++){
                if(A[i] == B[j])
                    result[i] = j;
            }
        }
        return result;
    }
}
