class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        Arr a = new Arr(nums1, nums2);
        int mid = a.mid();
        double result = 0;
        while(mid-- > 0) a.next();
        result = a.next();
        if(!a.isOddLen()) result = (result + a.next()) / 2;
        return result;
    }
    
    public static class Arr{
        private int[] a1;
        private int[] a2;
        private int idx1;
        private int idx2;
        public Arr(int[] arr1, int[] arr2){
            this.a1 = arr1.length == 0 ? null : arr1;
            this.a2 = arr2.length == 0 ? null : arr2;
        }
        public int next(){
            if(a1 != null && idx1 >= a1.length) return a2[idx2++];
            else if(a2 != null && idx2 >= a2.length) return a1[idx1++];
            int a = a1 == null ? Integer.MAX_VALUE : a1[idx1];
            int b = a2 == null ? Integer.MAX_VALUE : a2[idx2];
            if(a < b){
                idx1++;
                return a;
            }else{
                idx2++;
                return b;
            }
        }
        public boolean isOddLen(){
            int totalLen = len();
            return (totalLen & 1) == 1;
        }
        public int mid(){
            int totalLen = len();
            return isOddLen() ? totalLen / 2 : (totalLen - 1) / 2;
        }
        private int len(){
            int len1 = a1 == null ? 0 : a1.length;
            int len2 = a2 == null ? 0 : a2.length;
            return len1 + len2;
        }
    }
}
