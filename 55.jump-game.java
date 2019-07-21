/*
 * @lc app=leetcode id=55 lang=java
 *
 * [55] Jump Game
 */
class Solution {
    public boolean canJump(int[] nums) {
       if(nums == null || nums.length == 0) return false;
       
       int N = nums.length;
      boolean[] memo = new boolean[N];
      memo[N - 1] = true;
      
      for(int i = N-2; i >= 0; i--){
        int steps = nums[i];
        for(int j = 1; j <= steps; j++){
            int dest = j + i;
            // System.out.printf("%d %d\n", i, dest);
            if(dest >= N - 1 || memo[dest]) memo[i] = true;
        }          
    }
      return memo[0];
    }
}

