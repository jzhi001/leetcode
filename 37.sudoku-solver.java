/*
 * @lc app=leetcode id=37 lang=java
 *
 * [37] Sudoku Solver
 */
class Solution {
    static Set<Integer> full = new HashSet<>();
    static int[][] ig = {{0, 0}, {0, 3}, {0, 6},
                            {3, 0}, {3, 3}, {3, 6},
                            {6, 0}, {6, 3}, {6, 6}};

    static{
        for(int i = 1; i <= 9; i++)
            full.add(i);
    }

    public void solveSudoku(char[][] board) {
        if(board == null || board.length == 0) return;

       List<Set<Integer>> rsets = new ArrayList<>(), csets = new ArrayList<>(), gsets = new ArrayList<>();
       
       Set<Integer> s = null;
       int remain = 81;
       //init sets
       for(int i = 0; i < 9; i++){
           rsets.add(new HashSet<>(full));
           csets.add(new HashSet<>(full));
           gsets.add(new HashSet<>(full));

           for(int j = 0; j < 9; j++){
                // each row
                if(board[i][j] != '.'){
                    remain--;
                    rsets.get(i).remove(board[i][j] - '0');
                }
                // each col
                if(board[j][i] != '.'){
                    remain--;
                    csets.get(i).remove(board[j][i] - '0');
                }             
           }
           // each grid
            int rcell = ig[i][0], ccell = ig[i][1];
            for(int m = 0; m < 3; m++){
                for(int n = 0; n < 3; n++){
                   int x = m + rcell, y = n + ccell;
                   if(board[x][y] == '.') continue;
                   gsets.get(i).remove(board[x][y] - '0'); 
                }
            }
       }

       while(remain > 0){
           for(int i = 0; i < 9; i++){
               int roff = ig[i][0], coff = ig[i][1];
                for(int m = 0; m < 3; m++){
                    for(int n = 0; n < 3; n++){
                        int r = roff + m, c = coff + n;
                        if(board[r][c] != '.') continue;
                        s = notinter(gsets.get(i), notinter(rsets.get(r), csets.get(c)));
                        if(s.size() == 1){
                            remain--;
                            int q = -1;
                            for(int e : s) q = e;
                            board[r][c] = (char)(q + '0');
                            rsets.get(r).remove(q);
                            csets.get(c).remove(q);
                            gsets.get(i).remove(q);
                        }
                    }
                }                   
           }
       }
    }
    // a + b - (ab)
    Set<Integer> notinter(Set<Integer> a, Set<Integer> b){
        Set<Integer> ans = new HashSet<>(a);
        for(int e : b){
            if(ans.contains(e))
                ans.remove(e);
            else 
                ans.add(e);
        }
        return ans;
    }
}

