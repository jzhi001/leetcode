/*
 * @lc app=leetcode id=32 lang=java
 *
 * [32] Longest Valid Parentheses
 */
class Solution {

    public int longestValidParentheses(String s) {
       int ans = 0;
       if(s == null || s.length() == 0) return ans;

       // start at i
       for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ')' || (s.length() - i < ans)) continue;
            Stack<Character> stk = new Stack<>();
            stk.push(s.charAt(i));
            //stop at j
            for(int j = i + 1; j < s.length(); j++){
                char c = s.charAt(j);
                if(c == '('){
                    stk.push(c);
                }else{
                    if(stk.empty() || stk.peek() == ')'){
                        break;
                    }else{
                        stk.pop();
                        if(stk.empty()){
                            ans = Math.max(ans, (j - i + 1));
                        }
                    }
                }
            }
       }
       return ans;
    }
}

