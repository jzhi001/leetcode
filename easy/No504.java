//can be imporved by puting procedures in one function
//by using adding if-return statements
class Solution {
    public String convertToBase7(int num) {
        if(num == 0) return "0";
        String result = num < 0 ? "-" : "";
        return result + calc(Math.abs(num) );
    }
    
    String calc(int num){
        return num == 0 ? "" : calc(num / 7) + (num % 7);
    }
}