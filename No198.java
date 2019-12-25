class Solution {
    public int rob(int[] A) {
        if(A == null || A.length == 0) return 0;
        int n = A.length;
        
        int[] m = new int[n+1];
        m[0] = 0; m[1] = A[0];
        
        for(int i=2; i<=n; i++){
            m[i] = Math.max(m[i-2] + A[i-1], m[i-1] );
        }
        
        //System.out.println(Arrays.toString(m) );
        
        return m[n];
    }
}
