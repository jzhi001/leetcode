import java.util.List;

/*
 * @lc app=leetcode id=54 lang=java
 *
 * [54] Spiral Matrix
 */
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
       if(matrix == null || matrix.length == 0) return ans;
       
       int R = matrix.length, C = matrix[0].length;
       int remain = R * C;
        int level = 0;

        while(remain > 0){
            for(int i = level; remain > 0 && i < C - level; i++){
                ans.add(matrix[level][i]);
                remain--;
            }
            for(int i = level + 1; remain > 0 && i < R - level; i++){
                ans.add(matrix[i][C-1-level]);
                remain--;
            }

            for(int i = C - level - 2; remain > 0 && i >= level; i--){
                ans.add(matrix[R-1-level][i]);
                remain--;
            }

            for(int i = R-2-level; remain > 0 && i > level; i--){
                ans.add(matrix[i][level]);
                remain--;
            }
            level++;
        }

        return ans;
    }
}

