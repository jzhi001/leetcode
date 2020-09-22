/**
* https://www.lintcode.com/problem/regular-expression-matching/description
*/
public class Solution {
    String s, p;
    char[] arr;
    int sure;
    /**
     * @param s: A string 
     * @param p: A string includes "." and "*"
     * @return: A boolean
     */
    public boolean isMatch(String s, String p) {
        if(p.equals(".*") ) return true;
        this.s =s; this.p = p; this.arr = s.toCharArray();
        
        char[] arr = p.toCharArray();
        List<Character> list = new ArrayList<>();
        
        for(int i=0; i<arr.length; i++){
            list.add(arr[i]);
            if(i+1<arr.length && arr[i+1]=='*'){
                list.add('*');
                i++;
            }
            else sure++;
        }
        
        return match(list, s.length() - sure );
    }
    
    boolean match(List<Character> p, int maxStar){
        int is = 0;
        
        // p.forEach(c -> System.out.print(c));
        // System.out.println();
        
        for(int i=0; i<p.size(); i++){
            char c = p.get(i);
            boolean star = i+1 < p.size() && p.get(i+1) == '*' ;
            if(star){
                for(int j=0; j<=maxStar; j++){
                    int m;
                    List<Character> sub = new ArrayList<>();
                    for(m = 0; m < i; m++) sub.add(p.get(m));
                    for(m = 0; m < j; m++) sub.add(c);
                    for(m = i+2; m < p.size(); m++ ) sub.add(p.get(m) );
                    if(match(sub, maxStar - j) ) return true;
                }
                return false;
            }else{
                if(is >= arr.length || !(c == '.' || c == arr[is]) ) return false;
                is++;
            }
        }
        
        return is == arr.length;
    }
}
