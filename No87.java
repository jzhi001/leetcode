class Solution {
    public boolean isScramble_recur(String a, String b) {
        if(a == null || b == null) return a == b;

        return isScramble(a, b, new HashMap<>());
    }

    boolean isScramble(String a, String b, Map<String, Boolean> memo){
        if(a.length() != b.length()) return false;
        else if(a.equals(b)) return true;
        else if(!sameChars(a, b)) return false;

        String key = a + '#' + b;

        Boolean cached = memo.get(key);

        if(cached != null) return cached;

        final int N = a.length();

        for(int i = 1; i < a.length(); i++){
            int headLen = i;
            int tailLen = N - headLen;
            cached = isScramble(a.substring(0, headLen),b.substring(0, headLen))
                    && isScramble(a.substring(headLen), b.substring(headLen));
            if(cached) break;

            cached = isScramble(a.substring(0, tailLen), b.substring(headLen))
                    && isScramble(a.substring(tailLen), b.substring(0, headLen));
            if(cached) break;
        }
        
        memo.put(key, cached);
        return cached;
    }

    boolean sameChars(String a, String b){
        int[] A = new int[26];
        for(int i = 0; i < a.length(); i++){
            A[a.charAt(i) - 'a']++;
            A[b.charAt(i) - 'a']--;
        }
        for(int i = 0; i < 26; i++){
            if(A[i] != 0) return false;
        }
        return true;
    }
}