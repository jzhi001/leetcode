//better sulution is to use bit manipulation
//f[i] = f[i >> 1] + (i & 1)
class Solution {
    public int[] countBits(int num) {
        int[] result = new int[num+1];
        for(int j = 0; j<=num;j++){
            String each = Integer.toBinaryString(j);
            int count = 0;
            if(each.indexOf("1") != -1){
                for(int i=0; i<each.length(); i++){
                    if(each.charAt(i) == '1')   count++;
                }
            }
            result[j] = count;
        }
        return result;
    }
}
