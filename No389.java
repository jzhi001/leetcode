//best solution is using XOR a^b^c^b^a = c
//another one is sum of s arr minus sum of t arr, and (char)result
public class Solution {

	public char findTheDifference(String s, String t) {
		if (s == "")
			return t.charAt(0);
		char[] src = s.toCharArray();
		char[] tar = t.toCharArray();
		
		Arrays.sort(src);
		Arrays.sort(tar);

		for (int i = 0; i < src.length; i++) {
			if (src[i] != tar[i])
				return tar[i];
		}
		return 'a';
	}
}
