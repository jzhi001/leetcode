//can be improved by bit manipulation
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        String str = Integer.toBinaryString(n);
        char[] list = str.toCharArray();
        
        int count = 0;
        
        for(char each : list) {
        	if(each == '1') {
        		count ++;
        	}
        }
        return count;
    }
}
