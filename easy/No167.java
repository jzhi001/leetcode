class Solution {
    public int[] twoSum(int[] numbers, int target) {
        
        Map<Integer,Integer> map = new HashMap<>();
        int[] result = new int[2];
        
        for(int i=0; i<numbers.length; i++){
            Integer temp = map.get(target - numbers[i]);
            if(temp != null){
                result[0] = Math.min(temp, i+1);
                result[1] = Math.max(temp, i+1);
                return result;
            }
            map.put(numbers[i], i+1);
        }
        return null;
    }
}