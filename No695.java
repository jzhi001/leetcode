// close to answer
// this is depth first solution
class Solution {
    
    private int[][] grid;
    private int max = 0;
    private int temp = 0;
    
    public int maxAreaOfIsland(int[][] grid) {
        this.grid = grid;
        
        for(int i=0; i<grid.length; i++){
            int[] row = grid[i];
            for(int j=0; j<row.length; j++){
                
                if(row[j] == 0) continue;
                //once catch 1
                else{
                    temp = 1;
                    //check up down left and right
                    row[j] = 0;
                    move(i, j);
                    max = Math.max(temp, max);
                }
            }
        }
        return max;
    }
        
        private void move(int i, int j){
             //up
            check(i - 1, j);
            //down
            check(i + 1, j);
            //left
            check(i, j - 1);
            //right
            check(i, j + 1);
        }
        
        private void check(int row, int col){
            if(row <0 || col < 0 || row > grid.length - 1 || col > grid[row].length - 1)  return;
            if(grid[row][col] == 0) return;
            else{
                temp ++;
                grid[row][col] = 0;
                //recursion 
                move(row, col);
            }
        }
    }
