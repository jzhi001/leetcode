//can be improved by number calaulation
class Solution {
    public int reverse(int x) {
        if(x < 10 && x > -10)   return x;
        
        String temp = x < 0 ? "-" : "";
        String str = String.valueOf(x);
        str = str.charAt(0) == '-' ? str.substring(1) : str;
        int len = str.length();
        for(int i = len-1 ; i>=0; i--){
            temp += str.charAt(i);
        }
        long result = Long.valueOf(temp);
        if(result > (int)(Math.pow(2,31)-1) || result < -(int)(Math.pow(2,31))){
            return 0;
        }
        return (int)(result);
    }
}