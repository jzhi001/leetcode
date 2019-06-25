/*
 * @lc app=leetcode id=53 lang=java
 *
 * [53] Maximum Subarray
 */
class Solution {
    public int maxSubArray(int[] A) {
       if(A == null || A.length == 0) return 0;
       
       int ans = Integer.MIN_VALUE, local = 0;

       for(int i = 0; i < A.length; i++){
           local = Math.max(A[i], local + A[i]);
           ans = Math.max(ans, local);
       }
       return ans;
    }
}

