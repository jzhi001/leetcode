/*
 * @lc app=leetcode id=77 lang=java
 *
 * [77] Combinations
 */
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ret = new ArrayList<>();
        
        if(n < 1 || k < 1) return ret;
        return recur(1, n, k);
    }
    
    private List<List<Integer>> recur(int s, int e, int k){
        List<List<Integer>> ret = new ArrayList<>();
        
        if(k == 1){
            for(int i = s; i <= e; i++)
                ret.add(Arrays.asList(i));
            return ret;
        }
        
        for(int i = s; i <= e - k + 1; i++){
            List<List<Integer>> sub = recur(i + 1, e, k - 1);
            for(List<Integer> each : sub){
                LinkedList<Integer> list = new LinkedList<>(each);
                list.addFirst(i);
                ret.add(list);
            }
        }
        return ret;
    }
}