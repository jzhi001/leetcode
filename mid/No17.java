class Solution {
    List<String> result = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() < 1) return  result;
        return recur(digits);
    }
    //recur 
    //map2letters(firstLetter).foreach(c -> c + allPossibilities(tail(input)))
    private List<String> recur(String str){
        List<String> result = new ArrayList<>();
        if(str.length() == 0) return Arrays.asList("");
        
        String current = map2letters(str.charAt(0) - '0');
        List<String> tails = recur(str.substring(1));
        for(char c : current.toCharArray()){
            for(String tail : tails)
                result.add(String.valueOf(c) + tail);
        }
        return result;
    }
    
    private String map2letters(int x){
        if(x == 1) return "";
        else if (x == 2) return "abc";
        else if (x == 3) return "def";
        else if (x == 4) return "ghi";
        else if (x == 5) return "jkl";
        else if (x == 6) return "mno";
        else if (x == 7) return "pqrs";
        else if (x == 8) return "tuv";
        else return "wxyz";
    }
}
