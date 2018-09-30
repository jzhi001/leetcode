class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) return "";
        
        StringBuilder result = new StringBuilder("");
        
        int len = minLen(strs);
        
        for(int cidx = 0; cidx < len; cidx++){
            char expect = strs[0].charAt(cidx);
            for(int aidx = 0; aidx < strs.length; aidx++){
                if(aidx == 0) continue;
                char c = strs[aidx].charAt(cidx);
                if(c != expect) return result.toString();
            }
            result.append(expect);
        }
        return result.toString();
    }
    
    private static int minLen(String[] arr){
        int result = Integer.MAX_VALUE;
        for(String s : arr)
            result = Math.min(s.length(), result);
        return result;
    }
}
