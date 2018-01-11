//close to answer but O(N)
//best one is 
// a = 0
// for i in nums:
// 	a ^= i
// because a ^ a = 0
class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int each : nums){
            if(map.get(each) == null)   map.put(each, 1);
            else if (map.get(each) == 1)    map.remove(each);
        }
        return map.keySet().iterator().next();
    }
}
