//the better solution is that using a pointer started with 0
//when encounter a !0 number, insert it at pointer's position
//set all nums 0 from pointer+1 to the end

//better version with queue
class Solution {
 
    public void moveZeroes(int[] nums) {

		if (nums.length == 1)
			return;
		Queue<Integer> queue = new LinkedList<>();
		int size = -1;

		for (int each : nums) {
			if (each == 0) {
				continue;
			} else {
				queue.offer(each);
				size++;
			}
		}

		for (int i = 0; i < nums.length; i++) {
			if (i > size)
				nums[i] = 0;
			else {
				nums[i] = queue.poll();
			}
		}

    }
}


//the first version
public class Solution {

	public void moveZeroes(int[] nums) {

		if (nums.length == 1)
			return;
		int count = 0;

		int loop = 0;

		while (loop <= nums.length - count) {
			for (int i = 0; i < nums.length - count; i++) {
				if (nums[i] == 0) {
					for (int j = i; j < nums.length - 1 - count; j++) {
						nums[j] = nums[j + 1];
					}
					nums[nums.length - count - 1] = 0;
					count++;
				}
			}
			loop++;
		}
	}
}
