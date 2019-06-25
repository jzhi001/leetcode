/*
 * @lc app=leetcode id=49 lang=java
 *
 * [49] Group Anagrams
 */
class Solution {
    public List<List<String>> groupAnagrams(String[] A) {
        List<List<String>> ans = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        if(A == null || A.length == 0) return ans;
        
        for(String s : A){
            String sorted = sort(s);
            if(map.containsKey(sorted)){
                map.get(sorted).add(s);
            }else{
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(sorted, list);
            }
        }
        
        for(List<String> list : map.values()){
            ans.add(list);
        }
        
        return ans;
    }
    
    private String sort(String s){
        char[] chs = s.toCharArray();
        Arrays.sort(chs);
        return new String(chs);
    }
}

