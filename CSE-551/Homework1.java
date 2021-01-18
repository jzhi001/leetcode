import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.Instant;
import java.util.Random;

/**
 * Least requirement <b>Java SE 8 以上</b>
 * 
 * My Jdk version
 * <pre>
 * openjdk version "11.0.9" 2020-10-20
 * OpenJDK Runtime Environment (build 11.0.9+11)
 * OpenJDK 64-Bit Server VM (build 11.0.9+11, mixed mode)
 * </pre>
 * 
 * How to run? 
 * 
 * Nomal: {@code java Homework1 n} 
 * Debug: {@code java Homework1 n --debug}
 * <ul>
 * <li>n: length of array</li>
 * <li>--debug: check the answer and output sorted array to "sorted-${n}.txt"中</li>
 * </ul>
 */
public class Homework1 {

    private static final int RANDOM_MAX = 1000;

    private Random random = new Random();

    int[] mySort(int[] A) {

        int n = A.length;
        int B[] = new int[n];

        // loop variant: B[i+1:n) is sorted
        for (int i = n - 1; i >= 0; i--) {

            int k = -1; // index of maximum number in A[0, i]
            for (int j = 0; j <= i; j++) {
                // add io to make running time dirrerence more significant
                // System.out.printf("i: %d, j: %d, k: %d\n", i, j, k);
                if (k == -1 || A[k] < A[j]) {
                    k = j;
                }
                if (i + 1 < n && A[k] == B[i + 1]) {
                    break;
                }
            }

            B[i] = A[k];
            swap(A, i, k);
        }

        return B;
    }

    // check whether the output array is correct
    void check(int A[]) {
        int n = A.length;

        for (int i = 0; i < n - 1; i++) {
            if (A[i] > A[i + 1]) {
                throw new RuntimeException("WA in size " + n);
            }
        }
    }

    void outputResult(int[] A) {

        String fname = "sorted-" + A.length + ".txt";

        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(fname))) {

            for (int i = 0; i < A.length; i++) {
                if (i > 0) {
                    writer.write(", ");
                }
                writer.write(String.valueOf(A[i]));
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }

    void swap(int[] A, int i, int j) {
        int t = A[i];
        A[i] = j;
        A[j] = t;
    }

    int[] prepareArr(int size) {

        int[] A = new int[size];

        for (int i = 0; i < size; i++) {
            A[i] = random.nextInt(RANDOM_MAX);
        }

        return A;
    }

    static class StopWatch {
        Instant startTime;
        Instant endTime;

        void start() {
            startTime = Instant.now();
        }

        void stop() {
            endTime = Instant.now();
        }

        String report() {
            Duration d = Duration.between(startTime, endTime);
            return String.format("%d sec, %d ms", d.toSecondsPart(), d.toMillisPart());
        }
    }

    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("missing input: array size");
            System.exit(1);
        }

        int n = Integer.parseInt(args[0]);
        boolean debugMode = false;

        if (args.length >= 2 && "--debug".equals(args[1])) {
            debugMode = true;
        }

        Homework1 homework1 = new Homework1();
        StopWatch stopWatch = new StopWatch();

        int[] A = homework1.prepareArr(n);

        stopWatch.start();
        int[] B = homework1.mySort(A);
        stopWatch.stop();

        System.out.println(String.format("array size: %d, %s", n, stopWatch.report()));

        if (debugMode) {
            homework1.outputResult(B);
            homework1.check(B);
        }
    }
}
