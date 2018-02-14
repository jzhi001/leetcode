class Solution {
    public int dominantIndex(int[] nums) {
        int len = nums.length;
        if(len == 1)    return 0;
        int idx = 1;
        int max = -1;
        for(int i=0; i<len; i++){
            int dis = nums[i];
            if(dis > max){
                max = dis;
                idx = i;
            }
        }
        for(int i=0; i<len; i++){
            if(i == idx || nums[i] == 0)    continue;
            if(max / nums[i] < 2)   return -1;
        }
        return idx;
    }
}