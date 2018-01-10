//most importantly, always use numbers to proceed if possible
//instead of building a string, just recording length is way more faster
//solution to long, can be improved with 
//only one index when spliting 
//and record count by 
//arr[++i] = 1 if !eq to previous
//arr[i]++	if eq to previous
class Solution {
    public int countBinarySubstrings(String str) {
        if(str.indexOf('1')==-1 || str.indexOf('0') == -1)	return 0;
		int count =0 ;
		Stack<Integer> stack = split(str);
		while(stack.size()>1) {
			int now = stack.pop();
			int next = stack.peek();
			int temp = Math.min(now, next);
			count += temp;
		}
		return count;
    }
    private Stack<Integer> split(String str) {
		String[] arr = str.split("");
		Stack<Integer> stack = new Stack<>();
		int val = 0;
		int end = 1;
		String now = arr[0];
		int len = 1;

		while (end < arr.length) {
		
			if (arr[val].equals(arr[end])) {
				len++;
			} else {
				stack.push(len);
				now = arr[end];
				val = end;
				len = 1;
			}
			if(end == arr.length - 1)	stack.push(len);
			end++;
		}
		return stack;
	}
}
