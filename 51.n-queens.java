/*
 * @lc app=leetcode id=51 lang=java
 *
 * [51] N-Queens
 */
class Solution {
    public List<List<String>> solveNQueens(int n) {
        
        List<List<String>> ans = new LinkedList<>();

        // queen is at (i, memo[i])
        int[] memo = new int[n];
        Arrays.fill(memo, -1);
        
        List<int[]> ret = new LinkedList<>();
        recur(0, memo, ret);
        
        for(int[] each : ret){
            List<String> solution = new LinkedList<>();
            // get each row
            for(int i = 0; i < n; i++){
                String line = "";
                // get each column
                for(int j = 0; j < n; j++){
                    line += (each[i] == j) ? 'Q' : '.';
                }
                solution.add(line);
            }
            ans.add(solution);
        }
        return ans;
    }
    
    private void recur(int r, int[] memo, List<int[]> ret){
        // try each column at rth row
        for(int c = 0; c < memo.length; c++){
            if(!isValid(memo, r, c)) continue;
            
            int[] sub = Arrays.copyOf(memo, memo.length);
            sub[r] = c;
            
            if(r == memo.length - 1) ret.add(sub);
            else{
                recur(r + 1, sub, ret);
            }
        }
    }
    
    private boolean isValid(int[] memo, int r, int c){
        // System.out.printf("%d %d\n", r, c);
        // System.out.println(Arrays.toString(memo));
        if(memo[r] >= 0) return false; // in the same row
        for(int i = 0; i < memo.length; i++){
            if(memo[i] < 0) continue;
            else if(memo[i] == c) return false; // in the same column
            else if(memo[i] + i == r + c) return false; // SW-NE
            else if(memo[i] - c == i - r) return false; // NW-SE
        }
        return true;
    }
}

