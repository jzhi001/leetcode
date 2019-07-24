/*
 * @lc app=leetcode id=67 lang=java
 *
 * [67] Add Binary
 */
class Solution {
    public String addBinary(String a, String b) {
        int N = Math.max(a.length(), b.length()) + 1;
        
        int[] arr = new int[N];
        
        int ia = a.length() - 1, ib = b.length() - 1;
        int iarr = N - 1;
        int carry = 0;
        while(ia >= 0 || ib >= 0 || carry > 0){
            int digitA =  (ia >= 0) ? a.charAt(ia) - '0' : 0;
            int digitB = (ib >= 0) ? b.charAt(ib) - '0' : 0;
            int x = digitA + digitB + carry;
            
            if(x >= 2){
                carry = 1;
                x %= 2;
            }else{
                carry = 0;
            }
            
            arr[iarr--] = x;
            
            ia--;
            ib--;
        }
        
        StringBuilder sb = new StringBuilder();
        int j = 0;
        while(j < N - 1 && arr[j] == 0) j++;
        for(; j < N; j++) sb.append(arr[j]);
        return sb.toString();
    }
    
}

