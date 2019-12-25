class Solution {
    public void merge(int[] A, int m, int[] B, int n) {
        if(B == null || A == null) return;
        List<Integer> list = new ArrayList<>();
        int i=0, j=0;
        while(i<m || j<n){
            if(i == m) {
                while(j != n) list.add(B[j++]);
                break;
            }else if(j == n){
                while(i != m) list.add(A[i++]);
                break;
            }else{
                if(A[i] <= B[j]) list.add(A[i++]);
                else list.add(B[j++]);
            }
        }
        for(int p=0; p<m+n; p++) A[p] = list.get(p);
    }
}
