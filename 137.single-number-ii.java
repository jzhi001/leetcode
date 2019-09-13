/*
 * @lc app=leetcode id=137 lang=java
 *
 * [137] Single Number II
 */
class Solution {
    public int singleNumber(int[] A) {
        if(A == null) return 0;
        int N = A.length;
        
        Arrays.sort(A);
        int i = 0;
        while(i < N){
            if(i + 1 < N && A[i] != A[i + 1])
                return A[i];
            if(i == N - 1) return A[i];
            i += 3;
        }
        return 0;
    }
}

