public class Solution {
    List<List<Integer>> ret = new ArrayList<>();
    Set<List<Integer>> set = new HashSet<>();
    /*
     * @param :  A list of integers
     * @return: A list of unique permutations
     */
    public List<List<Integer>> permuteUnique(int[] A) {
        if(A == null || A.length == 0){
            ret.add(new ArrayList<>());
            return ret;
        }
        Arrays.sort(A);
        
        List<Integer> cand = new ArrayList<>();
        for(int x : A) cand.add(x);
        p(cand, new ArrayList<Integer>());
        ret.addAll(set);
        return ret;
    }
    
    void p(List<Integer> cand, List<Integer> list){
        if(cand.isEmpty()) {
            set.add(list);
            return;
        }
        
        for(int i=0; i<cand.size(); i++){
            int x = cand.get(i);
            
            List<Integer> scand = new ArrayList<>(cand);
            scand.remove(i);
            List<Integer> slist = new ArrayList<>(list);
            slist.add(x);
            p(scand, slist);
        }
    }
}
