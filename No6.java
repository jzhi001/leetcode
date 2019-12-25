class Solution {
    public String convert(String s, int row) {
        if(s == null || s.length() == 0) return s;
        if(s.length() <= row || row == 1) return s;
        Matrix m = new Matrix(s, row);
        m.settle();
        return m.read();
    }
    
    public static class Matrix{
        private Idx idx;
        public int row;
        public int col;
        private String str;
        private int gap;
        public int mainCol;
        public char[][] arr;
        private StrIterator si;
        
        public Matrix(String str, int row){
            this.str = str;
            this.row = row;
            this.gap = this.row - 2;
            this.col = col(str.length());
            this.arr = new char[row][this.col];
            this.idx = new Idx(this.arr);
            this.si = new StrIterator(str, row, this.gap);
        }
        public int col(int len){
            if(len == 0) return 0;
            int result = 1;
            len -= Math.min(this.row, len);
            this.mainCol++;
            if(len >= this.gap){
                result += this.gap;
                len -= this.gap;
            }else{
                result += len;
                len = 0;
            } 
            return result + col(len);
        }
        public void settle(){
            while(mainCol-- > 0){
                mainColSettle(si.nextMain());
                if(!si.hasRemain()) break;
                gapSettle(si.nextGap());
            }
        }
        private void mainColSettle(String str){
            // System.out.println("main " + str);
            for(int i=0; i<str.length(); i++){
                idx.set(str.charAt(i));
                idx.s();
            }
        }
        private void gapSettle(String str){
            // System.out.println("gap " + str);
            idx.n();
            for(int i=0; i<str.length(); i++){
                idx.ne();
                idx.set(str.charAt(i));
            }
            idx.ne();
        }
        public String read(){
            StringBuffer sb = new StringBuffer();
            for(int row=0; row<this.row; row++){
                for(int col=0; col < this.col; col++){
                    char c = arr[row][col];
                    if(c == 0) continue;
                    sb.append(c);
                }
            }
            return sb.toString(); 
        }
    }
    
    public static class StrIterator{
        private String str;
        private int row;
        private int gap;
        private int idx;
        public StrIterator(String str, int row, int gap){
            this.str = str;
            this.row = row;
            this.gap = gap;
        }
        public boolean hasRemain(){
            return idx < str.length();
        }
        public String nextMain(){
            return next(row);
        }
        public String nextGap(){
            return next(gap);
        }
        private String next(int len){
            int end = idx + len > str.length() ? str.length() : idx + len;
            String result = str.substring(idx, end);
            idx = end;
            return result;
        }
    }
    
    public static class Idx{
        private char[][] arr;
        private int row;
        private int col;
        public Idx(char[][] arr){
            this.arr = arr;
        }
        public void set(char val){
            // System.out.println("setting " + val + " at " + row + " " + col);
            arr[row][col] = val;
        }
        public void s(){
            row++;
        }
        public void ne(){
            col++;
            row--;
        }
        public void n(){
            row--;
        }
    }
}
