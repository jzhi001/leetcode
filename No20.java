class Solution {
    public boolean isValid(String s) {
        if(s == null || s.length() == 0) return true;
        
        Stack<Character> stack = new Stack<>();
        
        for(char c : s.toCharArray()){
            if(islp(c)){
                stack.push(c);
                continue;
            }
            
            if(stack.isEmpty())
                return false;
            else if(!pmatch(stack.peek(), c))
                return false;
            else
                stack.pop();
        }
        return stack.isEmpty() ? true : false;
    }
    
    private boolean islp(char c){
        return c == '(' || c == '[' || c == '{';
    }
    private boolean pmatch(char lf, char rt){
        if(lf == '(') return rt == ')';
        else if(lf == '[') return rt == ']';
        else if(lf == '{') return rt == '}';
        else return false;
    }
}
