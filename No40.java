class Solution {
    int[] arr;
    Set<List<Integer>> set = new HashSet<>();
    
    public List<List<Integer>> combinationSum2(int[] arr, int tar) {
        if(arr == null || arr.length == 0)  return new ArrayList<List<Integer>>();   
        this.arr = arr;
        Arrays.sort(arr);
        
        find(tar, new ArrayList<Integer>(), 0);
        return new ArrayList<List<Integer>>(set);
    }
    
    void find(int tar, List<Integer> list, int i){
        for(int j = i; j < arr.length; j++){
            int x = arr[j];
            if( x > tar) break;
            List<Integer> sub = new ArrayList<>(list);
            sub.add(x);
            if(x == tar){
                Collections.sort(sub);
                set.add(sub);
                continue;
            }
            find(tar - x, sub, j + 1);
        }
    }
}
