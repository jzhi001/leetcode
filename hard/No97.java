public class Solution {
    String a, b, tar;
    /**
     * @param s1: A string
     * @param s2: A string
     * @param s3: A string
     * @return: Determine whether s3 is formed by interleaving of s1 and s2
     */
    public boolean isInterleave(String a, String b, String tar) {
        this.a = a; this.b = b; this.tar = tar;
        if(a.length() + b.length() != tar.length() ) return false;
        return sub(0,0,0);
    }
    
    boolean sub(int ia, int ib, int it){
        if(it == tar.length() && ia == a.length() && ib == b.length() ) return true;
        // System.out.printf("%d %d %d\n", ia, ib, it);
        
        char ct = tar.charAt(it);
        boolean isA = false, isB = false;
        if(ia < a.length() &&  a.charAt(ia) == ct) isA = sub(ia+1, ib, it+1);
        if(ib < b.length() &&  b.charAt(ib)  == ct) isB = sub(ia, ib+1, it+1);
        return isA || isB;
    }
}
