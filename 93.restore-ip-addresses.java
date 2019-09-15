/*
 * @lc app=leetcode id=93 lang=java
 *
 * [93] Restore IP Addresses
 */
class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ret = new LinkedList<>();
        if(s == null || s.isEmpty()) return ret;
        
        return recur(s, 0, 0);
    }
    
    private List<String> recur(String s, int i, int count){
        
        count++;
        List<String> ret = new LinkedList<>();
        
        for(int len = 1; len <= 3; len++){
            if(count == 4 && i + len < s.length()) continue;
            
            int x = next(s, i, len);
            
            // System.out.printf("i: %d, len: %d, val: %d\n", i, len, x);
            if(x > 255 || x < 0) continue;
            
            if(count == 4) ret.add(String.valueOf(x));
            else{
                List<String> sub = recur(s, i + len, count);
                for(String each : sub){
                    ret.add(String.valueOf(x) + '.' + each);
                }
            }
        }
        
        return ret;
    }
    
    private int next(String s, int i, int len){
        if(i >= s.length() || i + len - 1 >= s.length()) return -1;
        int ret = 0;
        for(int off = 0; off < len; off++){
            int dig = s.charAt(i + off) - '0';
            if(off > 0 && ret == 0) return -1;
            ret = ret * 10 + dig;
        }
        return ret;
    }
}

