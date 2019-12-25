class Solution {
    
    private int w;
    private int h;
    
    public boolean isToeplitzMatrix(int[][] matrix) {
        w = matrix[0].length;
        h = matrix.length;
        
        boolean r1 = true;
        boolean r2 = true;
        for(int i=0; i<w-1;i++){
            r1 &= sub(matrix, 0, i);
            if(r1 == false) return false;
        }
        for(int i=0; i<h-1;i++){
            r2 &= sub(matrix, i, 0 );
            if(r2 == false) return false;
        }
        
        return true;
    }
    
    private boolean sub(int[][] arr, int y, int x){
        int val = arr[y++][x++];
        while(y<h && x<w){
            int temp = arr[y++][x++];
            if(temp != val)
                return false;
        }
        return true;
    }
}