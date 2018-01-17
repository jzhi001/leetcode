//can be improved by using set
public class Solution {

  public int lengthOfLongestSubstring(String s) {
    if (s == null) return 0;
    if (s.length() == 1) return 1;

    Map<Character, Integer> map = new HashMap<>();

    char[] arr = s.toCharArray();

    int max = 0;
    int now = 0;

    for (int i = 0; i < arr.length; i++) {
      for (int j = i; j < arr.length; j++) {
        if (map.get(arr[j]) == null) {
          map.put(arr[j], 1);
          now++;
        } else {
          break;
        }
      }
      map = new HashMap<>();
      max = Math.max(max, now);
      now = 0;
    }
    return max;
  }
}