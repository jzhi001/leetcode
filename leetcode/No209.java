public class No209 {
    public int minSubArrayLen_bruteForce(int s, int[] A) {
        if(A == null || A.length == 0) return 0;

        int N = A.length;

        int result = 0;

        for(int i = 0; i < N; i++){
            int prev = 0;
            for(int j = i; j < N; j++ ){
                int sum = 0;
                if(j == i) prev = sum = A[i];
                else{
                    sum =  prev + A[j];
                    prev = sum;
                }
                int len = j - i + 1;
                if(sum >= s){
                    if(result == 0) result = len;
                    else result = Math.min(result, len);
                }
            }
        }

        return result;

    }
}
