class Solution {
    public String longestPalindrome(String input) {
        if(input == null || input.length() < 2) return input;
        P p = new P();
        
        int len = input.length();
        for(int start = 0; start < len - 1; start++){
            for(int end = start; end < len; end++ ){
                if(isp(input, start, end) && p.shorterThan(end - start + 1))
                    p.update(input, start, end);
            }
        }
        return p.content;
    }
    
    private boolean isp(String input, int start, int end){
        int len = end - start + 1;
        if(len == 1) return true;
        int mid = start + len / 2;
        
        for(int i = start, j = end; i < mid; i++, j--){
            if(input.charAt(i) != input.charAt(j))
                return false;
        }
        return true;
    }
    
    public static class P{
        public String content = "";
        public boolean shorterThan(int len){
            return content.length() < len;
        }
        public void update(String input, int start, int end){
            this.content = input.substring(start, end + 1);
        }
    }
}
