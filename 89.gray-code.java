/*
 * @lc app=leetcode id=89 lang=java
 *
 * [89] Gray Code
 */
class Solution {
    public List<Integer> grayCode(int n) {
       Set<Integer> set = new HashSet<>();
       List<Integer> ans = new ArrayList<>();
       
       ans.add(0);
       set.add(0);

       if(n == 0){
           return ans;
       }

       int[] arr = new int[n];

       while(true){
           //find a next
           boolean find = false;
            for(int i=0; i<arr.length; i++){
                flip(arr, i);
                int x = b2d(arr);
                if(!set.contains(x)){
                    find = true;
                    set.add(x);
                    ans.add(x);
                    break;
                }else{
                    flip(arr, i);
                }
            }
            if(!find) break;
       }

       return ans;
    }

    private void flip(int[] arr, int i){
        arr[i] = (arr[i] == 0) ? 1 : 0;
    }

    private int b2d(int[] arr){
        int len = arr.length, ret = 0;
        for(int i=0; i < len; i++){
            if(arr[i] == 0) continue;
            ret += 1 << (len - i - 1);
        }
        return ret;
    }
}

