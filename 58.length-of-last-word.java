/*
 * @lc app=leetcode id=58 lang=java
 *
 * [58] Length of Last Word
 */
class Solution {
    public int lengthOfLastWord(String s) {
       if(s == null || s.isEmpty() ) return 0;
       
       int ans = 0;
       int i = s.length() - 1;
       while(i >= 0 && s.charAt(i) == ' ') i--;
        while(i >= 0 && s.charAt(i) != ' '){
            ans++;
            i--;
        }
        return ans;
    }
}

