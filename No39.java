class Solution {
    int[] arr;
    Set<List<Integer>> set = new HashSet<>();
    
    public List<List<Integer>> combinationSum(int[] arr, int tar) {
        if(arr == null || arr.length < 1) return new ArrayList<List<Integer>>(set);   
        this.arr = arr; 
        Arrays.sort(arr);
        find(tar, new ArrayList<Integer>());
        return new ArrayList<List<Integer>>(set);
    }
    
    void find(int tar, List<Integer> list){
        for(int i=0; i<arr.length; i++){
            int x = arr[i];
            if(x > tar) break;
            List<Integer> sub = new ArrayList<>(list);
            sub.add(x);
            if(tar == x){
                Collections.sort(sub);
                set.add(sub);
                continue;
            }
            find(tar - x, sub);
        }
    }
}
