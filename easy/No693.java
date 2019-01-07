//can be improved by regex "00|11"
class Solution {
    public boolean hasAlternatingBits(int n) {

		if (n == 0)
			return true;

		Stack<Integer> stack = new Stack<>();
		while (n > 0) {
			stack.push(n % 2);
			n /= 2;
		}

		while (stack.size() > 1) {
			if (stack.pop() == stack.peek())
				return false;
		}
		return true;

	}
}