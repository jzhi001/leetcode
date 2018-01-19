// Arrays.equals()
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s == null || t == null)
            return false;
        if(s.length() != t.length())
            return false;
        if(s.equals(t))
            return true;
        
        char[] s_l = s.toCharArray();
        char[] t_l = t.toCharArray();
        Arrays.sort(s_l);
        Arrays.sort(t_l);
        
        s = String.valueOf(s_l);
        t = String.valueOf(t_l);
        return s.equals(t);
    }
}