//tricks can be made because arr is binary
//int n;
//for(int each : nums) -> {n = each == 0 ? 0 : n+1};
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        if(nums==null || nums.length==0)    return 0;
        
        Stack<Integer> stack = new Stack<>();
        for(int each: nums){
            stack.push(each);
        }
        
        int max = 0;
        int count = 0;
        
        while(!stack.isEmpty()){
            int temp = stack.pop();
            if(temp==1){
                count++;
            }else{
                max = Math.max(max, count);
                count = 0;
            }
        }
        max = Math.max(max, count);
        return max;
    }
}