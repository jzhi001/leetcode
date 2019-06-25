/*
 * @lc app=leetcode id=42 lang=java
 *
 * [42] Trapping Rain Water
 */
class Solution {
    public int trap(int[] A) {
        if(A == null || A.length < 2) return 0;

        int ans = 0, i = 0;

        while(i <= A.length - 3){
            if(A[i] == 0){
                i++;
                continue;
            }

            int j = i + 1;
            // find rt
            // the closest one which ge lf
            // if no ge lf, then pick the farest max
            int imax = -1;
            boolean higherRt = false;
            while(j < A.length){
                if(A[j] >= A[i]){
                    higherRt = true;
                    break;
                }
                if(imax == -1){
                    imax = j;
                }else{
                    if(A[j] >= A[imax]) imax = j;
                }
                j++;
            }
            if(!higherRt) j = imax;

            if(j - i == 1 || j >= A.length){
                i++;
                continue;
            }

            int width = j - i - 1, height = Math.min(A[i], A[j]);
            int water = width * height;
            for(int m = i + 1; m < j; m++){
                water -= A[m];
            }
            ans += water;
            i = j;
        }
        return ans;
    }
}

