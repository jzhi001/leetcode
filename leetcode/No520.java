//can be improved by calc with count of upper letters
//note that char has isUpper() and isLower()
class Solution {
    public boolean detectCapitalUse(String word) {
        if(word.length() == 1)   return true;
        char[] arr = word.toCharArray();
        if(arr[0] >= 97 ){
            for(int i=1; i<arr.length; i++){
                if(arr[i] < 97) return false;
            }
        }else{
            if(word.length() < 3)   return true;
            boolean isCap = arr[1] <97 ? true : false;
            for(int i=2; i<arr.length; i++){
                if( (arr[i]<97) != isCap   )    return false;
            }
        }
        return true;
    }
}
