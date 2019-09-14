/*
 * @lc app=leetcode id=60 lang=java
 *
 * [60] Permutation Sequence
 */
class Solution {
    public String getPermutation(int n, int k) {
        int[] A = new int[n];
        for(int i = 0; i < A.length; i++)
            A[i] = i + 1;
        
        for(int i = 1; i < k; i++)
            next(A);
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < A.length; i++)
            sb.append(A[i]);
        return sb.toString();
    }
    
    void next(int[] A){
        int i = A.length - 1;
        while(i > 0 && A[i] < A[i - 1]) i--;
        
        int j = i - 1;
        int nxtJ = i;
        for(int p = i; p < A.length; p++){
            if(A[p] > A[j] && A[p] < A[nxtJ]) nxtJ = p;
        }
        
        int tmp = A[nxtJ];
        A[nxtJ] = A[j];
        A[j] = tmp;
        
        Arrays.sort(A, i, A.length);
    }
}

