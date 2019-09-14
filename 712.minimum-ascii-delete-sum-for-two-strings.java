/*
 * @lc app=leetcode id=712 lang=java
 *
 * [712] Minimum ASCII Delete Sum for Two Strings
 */
class Solution {
    public int minimumDeleteSum(String a, String b) {
        int alen = a.length();
        int blen = b.length();
        
        int[][] memo = new int[alen+1][blen+1];
        
        memo[0][0] = 0;
        for(int i = 1; i <= alen; i++) memo[i][0] = memo[i-1][0] + a.charAt(i-1);
        for(int i = 1; i <= blen; i++) memo[0][i] = memo[0][i-1] + b.charAt(i-1);
        
        for(int r = 1; r <= alen; r++){
            for(int c = 1; c <= blen; c++){
                int ca = a.charAt(r-1);
                int cb = b.charAt(c-1);
                
                int nw = memo[r-1][c-1] + ((ca == cb) ? 0 : ca + cb);
                int w = memo[r][c-1] + cb;
                int n = memo[r-1][c] + ca;
                
                memo[r][c] = Math.min(Math.min(w, n), nw);
            }
        }
        
        // for(int i = 0; i <= alen; i++)
        //     System.out.println(Arrays.toString(memo[i]));
        return memo[alen][blen];
    }
    
}

