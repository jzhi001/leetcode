/*
 * @lc app=leetcode id=44 lang=java
 *
 * [44] Wildcard Matching
 */
class Solution {
    public boolean isMatch(String s, String p) {
        if(s == null || p == null) return false;
        
        int minlen = 0; // non star chars in pattern
        for(int i = 0; i < p.length(); i++){
            if(p.charAt(i) != '*') minlen++;
        }

        if(minlen > s.length()) return false;

        return recur(s, p, 0, 0, s.length() - minlen);
    }

    private boolean recur(String s, String p, int is, int ip, int wild){
        if(ip >= p.length()) return is >= s.length();

        char c = 0;
        while(ip < p.length() && (c = p.charAt(ip)) != '*'){
            if(is >= s.length()) return false;
            if(c != '?' && c != s.charAt(is)) return false;
            is++;
            ip++;
        }
        if(ip == p.length()) return is >= s.length();
        // skip continuous stars
        while(ip + 1 < p.length() && p.charAt(ip + 1) == '*') ip++;
        // skip 0...wild chars
        for(int i = 0; i <= wild; i++){
            if(recur(s, p, is + i, ip + 1, wild - i)) return true;
        }
        return false;
        
    }
}

