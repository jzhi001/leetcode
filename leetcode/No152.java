public class No152 {
    public int maxProduct_bruteForce(int[] A) {
        if (A == null || A.length == 0) return 0;

        int ret = Integer.MIN_VALUE;

        for (int i = 0; i < A.length; i++) {

            int product = 1;
            int j = i;
            while (j < A.length) {
                product *= A[j];
                ret = Math.max(ret, product);
                j++;
            }
        }

        return ret;
    }
}