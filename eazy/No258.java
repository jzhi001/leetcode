class Solution {
    public int addDigits(int num) {
        String temp = num + "";
        int n = sub(temp);
        while( n >= 10){
            n = sub(n + ""); 
        }
        return n;
    }
    
    private int sub(String n){
        return n.length() == 1? Integer.parseInt(n) : Integer.parseInt(n.substring(0,1)) + sub(n.substring(1));
    }
}

// the better one line solution
// return num == 0 ? 0 : (num % 9 == 0 ? 9 : (num % 9));
// or 
// return 1 + (num - 1) % 9;
