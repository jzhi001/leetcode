class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for(int each : nums){
            map.put(each, each);
        }
        for(int i=1; i<nums.length+1; i++){
            if(map.get(i) == null)  list.add(i);
        }
        return list;
    }
}
