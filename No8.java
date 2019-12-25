import java.math.BigInteger;

class Solution {
    public int myAtoi(String str) {
        str = str.trim();
        if(str == null || str.length() == 0) return 0;
        str = getNum(str);
        if(str == null) return 0;
        BigInteger x = new BigInteger(str);
        int cmp = x.compareTo(BigInteger.ZERO);
        if(cmp > 0)
            x = x.min(BigInteger.valueOf(Integer.MAX_VALUE));
        else if(cmp < 0){
            x = x.max(BigInteger.valueOf(Integer.MIN_VALUE));
        }
        return x.intValue();
    }
    
    private String getNum(String str){
        int end = 0;
        if(str.charAt(0) == '-' || str.charAt(0) == '+') end++;
        while(end < str.length()){
            char c = str.charAt(end);
            if(c < '0' || c > '9') break;
            end++;
        }
        String result = str.substring(0, end);
        if(result.equals("-") || result.equals("+") || result.length() == 0) return null;
        return result;
    }
}
