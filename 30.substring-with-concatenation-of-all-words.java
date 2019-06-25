import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=30 lang=java
 *
 * [30] Substring with Concatenation of All Words
 */
class Solution {

    public List<Integer> findSubstring(String s, String[] words) {
       List<Integer> ans = new ArrayList<>();
       if(s == null || s.length() == 0 || words == null || words.length == 0) return ans;
       
        int totlen = words[0].length() * words.length;
        int i = 0;
        
        Map<String, Integer> map = new HashMap<>();
        for(String w : words){
            map.merge(w, 1, (o, v) -> o + v);
        }

        while(i <= s.length() - totlen){
            if(match(s, new HashMap<>(map), i, words.length, words[0].length())){
                ans.add(i);
            }
            i++;
        }
        return ans;
    }

    private boolean match(String s, Map<String, Integer> map, int i, int nwords, int wlen){
        for(int j = 0; j < nwords; j++){
            int idx = i + j * wlen;
            String tar = s.substring(idx, idx + wlen);

            if(!map.containsKey(tar)) return false;
            int v = map.get(tar);
            if(v > 0){
                map.put(tar, v - 1);
            }else{
                return false;
            }
        }
        return true;
    }
}

