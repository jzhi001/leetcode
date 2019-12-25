class Solution {
    public List<String> generateParenthesis(int n) {
        if(n < 1) return new ArrayList<String>();
        return draw(n, n);
    }
    
    private List<String> draw(int nleft, int nrt){
        List<String> result = new ArrayList<>();
        if(nleft == 0 && nrt == 0){
            result.add("");
            return result;
        }
        
        if(nleft > 0){
            List<String> subs = draw(nleft - 1, nrt);
            for(String each : subs)
                result.add("(" + each);
        }
        
        if(nrt > 0 && nleft < nrt){
            List<String> subs = draw(nleft, nrt - 1);
            for(String each : subs)
                result.add(")" + each);
        }
        
        return result;
    }
}
