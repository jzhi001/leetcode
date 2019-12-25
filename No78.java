
public class Solution {
    List<List<Integer>> ret = new ArrayList<>();
    int[] A;
    /**
     * @param nums: A set of numbers
     * @return: A list of lists
     */
    public List<List<Integer>> subsets(int[] A) {
        this.A = A;
       ret.add(new ArrayList<Integer>()); 
       if(A == null || A.length == 0) return ret;
       
       List<Integer> cand = new ArrayList<>();
       for(int x : A) cand.add(x);
       p(0, new ArrayList<Integer>());
       return ret;
    }
    
    void p(int idx, List<Integer> list){
        if(idx == A.length) return;
        
        for(int i=idx; i<A.length; i++){
            int x = A[i];
            
            List<Integer> slist = new ArrayList<>(list);
            slist.add(x);
            Collections.sort(slist);
            ret.add(slist);
            
            p(i + 1, slist);
        }
    }
}
