/*
 * @lc app=leetcode id=41 lang=java
 *
 * [41] First Missing Positive
 */
class Solution {
    public int firstMissingPositive(int[] A) {
       if(A == null || A.length == 0) return 1;
       
       Arrays.sort(A);
       if(A[A.length - 1] <= 0) return 1; // all neg
       int missing = 1;
       while(true){
           if(Arrays.binarySearch(A, missing) < 0)
                return missing;
            else
                missing++;
       }
    }

    
}

