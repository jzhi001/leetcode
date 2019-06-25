/*
 * @lc app=leetcode id=12 lang=java
 *
 * [12] Integer to Roman
 */
class Solution {
    public String intToRoman(int n) {
       StringBuilder ans = new StringBuilder();
       
       n = rua(true, n, "M", 1000, ans);
       n = rua(false, n, "CM", 900, ans);
       n = rua(true, n, "D", 500, ans);
       n = rua(false, n, "CD", 400, ans);
       n = rua(true, n, "C", 100, ans);
       n = rua(false, n, "XC", 90, ans);
       n = rua(true, n, "L", 50, ans);
       n = rua(false, n, "XL", 40, ans);
       n = rua(true, n, "X", 10, ans);
       n = rua(false, n, "IX", 9, ans);
       n = rua(true, n, "V", 5, ans);
       n = rua(false, n, "IV", 4, ans);
       n = rua(true, n, "I", 1, ans);

       return ans.toString();
    }

    private int rua(boolean single, int n, String ch, int val, StringBuilder cur){
        if(single){
            int x = n / val;
            while(x-- > 0){
                cur.append(ch);
                n -= val;
            }
        }else{
            if(n >= val){
                cur.append(ch);
                n -= val;
            }
        }
        return n;
    }
}

