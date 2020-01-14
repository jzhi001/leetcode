public class No238 {
    public int[] productExceptSelf(int[] A) {
        if (A == null || A.length == 0) return null;

        int N = A.length;

        int[] L = new int[N + 2];
        L[0] = L[N] = 1;

        for (int iLeft = 1; iLeft < N; iLeft++) {
            int iArr = iLeft - 1;
            int val = (iArr < 0 || iArr >= N) ? 1 : A[iArr];
            L[iLeft] = val * L[iLeft - 1];
        }

        int[] R = new int[N + 2];
        R[0] = R[N] = 1;

        for (int iRight = N - 1; iRight >= 0; iRight--) {
            int iArr = iRight + 1;
            int val = (iArr < 0 || iArr >= N) ? 1 : A[iArr];
            R[iRight] = val * R[iRight + 1];
        }

        int[] ret = new int[N];
        for (int i = 0; i < N; i++) {
            ret[i] = L[i] * R[i];
        }

        return ret;

    }

    public int[] productExceptSelf_o1_space(int[] A) {
        if(A == null || A.length == 0) return null;

        int N = A.length;

        int[] ret = new int[N];

        ret[0] = 1;

        for(int i = 1; i < N; i++){
            ret[i] = ret[i - 1] * A[i - 1];
        }

        int R = 1;

        for(int i = N - 2; i >= 0; i--){
            ret[i] *= R * A[i + 1];
            R *= A[i + 1];
        }

        return ret;

    }
}