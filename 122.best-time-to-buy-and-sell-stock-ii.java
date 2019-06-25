/*
 * @lc app=leetcode id=122 lang=java
 *
 * [122] Best Time to Buy and Sell Stock II
 */
class Solution {
    public int maxProfit(int[] P) {
       int ans = 0;
       if(P == null || P.length == 0) return ans;

       for(int i = 0; i < P.length - 1; i++){
            if(P[i] < P[i + 1]){
                ans += P[i + 1] - P[i];
            }
       }
       return ans;
    }

}

