/*
s = sum nums
leftSum = 0
for(int i=0; i<N, i++){
    rightSum = s - leftSum - nums[i]
    if leftSum == rightSum
        return i
    leftSum += nums[i]
}
return -1
*/
class Solution {
    public int pivotIndex(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            int left = sum(nums, 0, i);
            int right = sum(nums, i + 1, nums.length);
            if(left == right)
                return i;
        }
        return -1;
    }
    
    private int sum(int[] arr, int from, int dest){
        int result = 0;
        for(int i=from; i<dest; i++)
            result += arr[i];
        return result;
    }
}