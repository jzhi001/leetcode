/*
 * @lc app=leetcode id=43 lang=java
 *
 * [43] Multiply Strings
 */
class Solution {
    private static final int ANS_LEN = 500;
    
    public String multiply(String n1, String n2) {
        if(n1.equals("0") || n2.equals("0")) return "0";
        
        //diff long str and short str
        String lg = null, st = null;
        int len1 = n1.length(), len2 = n2.length();
        if(Math.max(len1, len2) == len1){
            lg = n1;
            st = n2;
        }else{
            lg = n2;
            st = n1;
        }
        
        int[] ans = new int[ANS_LEN];
        //multi digits of st to lg, add to ans
        for(int i = 0; i < st.length(); i++){
            int dig = st.charAt(st.length() - i - 1) - '0';
            if(dig == 0) continue;
            int[] tmp = muldig(lg, dig, i);
            add(ans, tmp);
        }
        
        StringBuilder sb = new StringBuilder();
        int j = 0;
        while(j < ANS_LEN && ans[j] == 0) j++;
        while(j < ans.length) sb.append(ans[j++]);
        
        return sb.toString();
    }
    
    private int[] muldig(String lg, int dig, int off){
        // System.out.printf("%s * %d at %d\n", lg, dig, off);
        int[] ret = new int[ANS_LEN];
        int carry = 0, j = ANS_LEN - 1 - off;
        for(int i = lg.length() - 1; i >= 0; i--){
            int prod = dig * (lg.charAt(i) - '0') + carry;
            carry = prod / 10;
            prod %= 10;
            
            if(j >= 0)
                ret[j--] = prod;
        }
        if (carry != 0) ret[j] = carry;
        return ret;
    }
    
    private void add(int[] A, int[] B){
        int carry = 0;
        for(int i = A.length - 1; i >= 0; i--){
            int x = A[i] + B[i] + carry;
            carry = x / 10;
            x %= 10;
            A[i] = x;
        }
    }
}

