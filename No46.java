
public class Solution {
    int[] A;
    List<List<Integer>> ret = new ArrayList<>();
    /*
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public List<List<Integer>> permute(int[] A) {
        if(A == null || A.length == 0) {
            ret.add(new ArrayList<Integer>());
            return ret;
        }
        this.A = A;
        
        List<Integer> cand = new ArrayList<>();
        for(int x : A) cand.add(x);
        permulation( cand, new ArrayList<Integer>());
        return ret;
    }
    
    void permulation(List<Integer> cand, List<Integer> list){
        if(cand.isEmpty() ){
            ret.add(list);
            return;
        }
        
        for(int x : cand){
            List<Integer> scand = new ArrayList<>();
            for(int i=0; i<cand.size(); i++ ){
                int cur = cand.get(i);
                if(cur == x) continue;
                scand.add(cur);
            }
            List<Integer> slist = new ArrayList<>(list);
            slist.add(x);
            permulation(scand, slist);
        }
    }
}
