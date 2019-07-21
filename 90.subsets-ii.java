/*
 * @lc app=leetcode id=90 lang=java
 *
 * [90] Subsets II
 */
class Solution {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<Integer>());

        if(nums == null || nums.length == 0) return ans;

        Arrays.sort(nums);
        recur(ans, nums, 0);

        return ans;
    }

    void recur(List<List<Integer>> ans, int[] nums, int i){
        if(i >= nums.length) return;

        int tot = 1;
        while(i < nums.length - 1 && nums[i] == nums[i+1]){
            tot++;
            i++;
        }

        List<List<Integer>> added = new ArrayList<>();

        for(List<Integer> list : ans){
            for(int j = 1; j <= tot; j++){
                List<Integer> sub = new ArrayList<>(list);
                for(int c = 0; c < j; c++) sub.add(nums[i]);
                added.add(sub);
            }
        }
        
        for(List<Integer> list : added) ans.add(list);

        recur(ans, nums, i+1);
    }
}

