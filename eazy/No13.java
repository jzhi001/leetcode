class Solution {
    public int romanToInt(String s) {
        if(s == null || s.length() == 0) return 0;
        int midIdx = Roman.midIdx(s);
        String rpart = midIdx >= s.length() - 1 ? null : s.substring(midIdx + 1);
        String lpart = midIdx == 0 ? null : s.substring(0, midIdx);
        return Roman.valOf(s.charAt(midIdx)) - romanToInt(lpart) + romanToInt(rpart);
    }
    
    public static class Roman{
        private static Map<Character, Integer> map = new HashMap<>();
        
        static{
            map.put('I', 1);
            map.put('V', 5);
            map.put('X', 10);
            map.put('L', 50);
            map.put('C', 100);
            map.put('D', 500);
            map.put('M', 1000);
        }

        public static int midIdx(String str){
            char biggest = 'I';
            for(char c : str.toCharArray()){
                if(map.get(c) > map.get(biggest))
                    biggest = c;
            }
            return str.indexOf(biggest);
        }
        
        public static int valOf(char c){
            return map.get(c);
        }
    }
}
