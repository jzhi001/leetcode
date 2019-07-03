/* * @lc app=leetcode id=91 lang=java 
* 
* [91] Decode Ways */
class Solution {
    public int numDecodings(String s) {
        if (s == null || s.charAt(0) == '0')
            return 0;
        int[] memo = new int[s.length() + 1];
        int len = s.length();
        memo[len] = 1;
        memo[len - 1] = s.charAt(len - 1) == '0' ? 0 : 1;
        for (int i = len - 2; i >= 0; i--) {
            int n = s.charAt(i) - '0';
            if (n == 0) {
                if (s.charAt(i + 1) == '0')
                    return 0;
                memo[i] = 0;
            } else {
                memo[i] = memo[i + 1];
                int d = n * 10 + (s.charAt(i + 1) - '0');
                if (d > 0 && d <= 26)
                    memo[i] += memo[i + 2];
            }
        }
        return memo[0];
    }
}