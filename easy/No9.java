class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        else if(x < 10) return true;
        
        char[] arr = String.valueOf(x).toCharArray();
        
        int mid = arr.length / 2;
        
        for(int front=0; front<mid; front++){
            int back = arr.length - front - 1;
            if(arr[front] != arr[back])
                return false;
        }
        return true;
    }
}
