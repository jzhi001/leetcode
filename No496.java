//eazy 
//bad solution
//can be improved by stack
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        int[] result = new int[nums1.length];
        for(int i=0; i<nums1.length; i++){
            result[i] = -1;
        }
            
        for(int i=0; i<nums1.length; i++){
            for(int j=0; j<nums2.length; j++){
                if(nums1[i] == nums2[j]){
                    //the greatest
                    if(j==nums2.length - 1) continue;
                    
                    for(int q=j+1; q<nums2.length; q++){
                        if(nums2[q] > nums1[i]){
                            
                            result[i] = nums2[q];
                            break;
                        }
                    }
                }
            }
        }
        return result;
    }
}