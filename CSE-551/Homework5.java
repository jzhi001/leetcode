import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Homework5 {

    public static void main(String[] args) {

        // new RandomTest(10).run();

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[] people = new int[n + 1];
        int[] equipments = new int[m + 1];

        for (int i = 1; i <= n; i++) {
            people[i] = scanner.nextInt();
        }

        for (int i = 1; i <= m; i++) {
            equipments[i] = scanner.nextInt();
        }

        List<Integer> choices = new ArrayList<>();
        int ans = bottomUp(people, equipments, choices);

        System.out.println("minimum sum: " + ans);
        System.out.println(choices);
    }

    public static int bottomUp(int[] people, int[] equipments, List<Integer> choices) {
        int n = people.length - 1;
        int m = equipments.length - 1;

        // state f(i, j) means for the first i people and j eqipments,
        // the minimum height difference among all possible choices

        // state change: whether to allocate j-th equipment to the i-th person
        // if no equipment for i-th person, +INF
        // if not allocate, state value is f(i, j - 1)
        // if allocate, state value is f(i - 1, j - 1) + height_diff(i, j)
        int f[][] = new int[n + 1][m + 1];
        for (int i = 0; i <= m; i++) {
            f[0][i] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j++) {

                if (j >= i) {
                    f[i][j] = Math.min(f[i][j - 1], f[i - 1][j - 1] + Math.abs(people[i] - equipments[j]));
                } else {
                    f[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        // for(int[] e : f) System.out.println(Arrays.toString(e));

        for (int i = n, j = m; i >= 1; j--) {

            if (j >= i && f[i][j] == f[i - 1][j - 1] + Math.abs(people[i] - equipments[j])) {
                choices.add(equipments[j]);
                i--;
            }
        }

        Collections.reverse(choices);

        return f[n][m];
    }

    public static class RandomTest {

        int cases;
        int bound = 200;

        Random random = new Random();

        RandomTest(int cases) {
            this.cases = cases;
        }

        int dfs(List<Integer> people, List<Integer> equipments) {

            Set<Integer> seen = new HashSet<>();

            return dfs(people, equipments, seen, 0);
        }

        int dfs(List<Integer> people, List<Integer> equipments, Set<Integer> seen, int i) {

            if (i >= people.size()) {
                return 0;
            }

            int ans = Integer.MAX_VALUE;

            for (int k = 0; k < equipments.size(); k++) {
                if (seen.contains(k)) {
                    continue;
                }

                seen.add(k);

                int diff = Math.abs(people.get(i) - equipments.get(k));
                ans = Math.min(ans, diff + dfs(people, equipments, seen, i + 1));

                seen.remove(k);
            }

            return ans;
        }

        int dp(List<Integer> people, List<Integer> equipments, List<Integer> choices) {

            int[] p = new int[people.size() + 1];
            int[] e = new int[equipments.size() + 1];

            for (int i = 0; i < people.size(); i++) {
                p[i + 1] = people.get(i);
            }

            for (int i = 0; i < equipments.size(); i++) {
                e[i + 1] = equipments.get(i);
            }

            return bottomUp(p, e, choices);
        }

        void run() {

            for (int i = 1; i <= cases; i++) {

                // use small numbers
                // time complexity of DFS is C n k (choosing n from k)
                int n = 10;
                int m = 12;

                List<Integer> people = IntStream.range(0, n).boxed().map(k -> random.nextInt(bound) + 1).sorted()
                        .collect(Collectors.toList());

                List<Integer> equipments = IntStream.range(0, m).boxed().map(k -> random.nextInt(bound) + 1).sorted()
                        .collect(Collectors.toList());

                System.out.println(people.stream().map(String::valueOf).collect(Collectors.joining(" ")));
                System.out.println();
                System.out.println(equipments.stream().map(String::valueOf).collect(Collectors.joining(" ")));
                System.out.println();

                int dfsAns = dfs(people, equipments);

                System.out.println(dfsAns);

                List<Integer> choices = new ArrayList<>();

                int dpAns = dp(people, equipments, choices);

                System.out.println(dpAns);

                if (dpAns != dfsAns) {

                    System.err.println("dfs: " + dfsAns + " dp: " + dpAns);
                    System.err.println("dp choices: " + choices);

                    System.exit(1);
                }
            }
        }

    }
}