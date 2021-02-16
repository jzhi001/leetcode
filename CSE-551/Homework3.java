import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Homework3 {

    private static final Scanner scanner = new Scanner(System.in);
    private static final int INF = 0x3f3f3f3f;

    static class Graph {
        private int n;
        private Map<Integer, List<Integer>> g;

        Graph(int nodeCount) {
            this.n = nodeCount;
            this.g = new HashMap<>();

            for (int i = 1; i <= n; i++) {
                g.put(i, new ArrayList<>());
            }
        }

        private void validNode(int x) {
            if (!g.containsKey(x)) {
                throw new IllegalArgumentException("invalid node number: " + x);
            }
        }

        public int nodeCount() {
            return n;
        }

        public void addEdge(int s, int t) {
            validNode(s);
            validNode(t);
            g.get(s).add(t);
        }

        public List<Integer> neighbours(int node) {
            validNode(node);
            return g.get(node);
        }
    }

    static class WebApi {
        private Random random;
        // last returned weight for certain edge
        // key is #{s + '.' + t}
        private Map<String, Integer> last;

        WebApi() {
            // Note: I used fix random seed for simpler debugging
            // You'll get same result as me with this seed
            // Please remove this for other test cases
            this.random = new Random(14557L);
            this.last = new HashMap<>();
        }

        public int getWeight(int s, int t) {
            String key = String.format("%d.%d", s, t);
            int w = last.computeIfAbsent(key, (k) -> 1);
            int delta = random.nextInt(10) + 1;
            w += delta;
            last.put(key, w);

            System.out.printf("weight of %d -> %d is %d\n", s, t, w);

            return w;
        }
    }

    /**
     * Input format: first line contains 2 numbers: number of nodes N and number
     * of edges M. Note the number of nodes are consecutive start from <b>1</b>. The
     * second line contains 2 numbers: starting node S and destination T. For the
     * next M lines, each line contains 2 number a and b, which means there's a
     * directed edge between a and b (a -> b).
     */
    public static void main(String[] args) {

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int s = scanner.nextInt();
        int t = scanner.nextInt();

        Graph g = new Graph(n);

        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            g.addEdge(a, b);
        }

        shortestPath(g, s, t);
    }

    public static void shortestPath(Graph G, int S, int T) {

        WebApi webApi = new WebApi();
        Set<Integer> seen = new HashSet<>();

        int n = G.nodeCount();

        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);

        int[] pre = new int[n + 1];

        dist[S] = 0;

        for (int i = 0; i < n; i++) {

            System.out.println("choosing next node");

            int here = -1;

            for (int j = 1; j <= n; j++) {
                System.out.printf("distance of %d -> %d is %s, %s in S\n", S, j,
                        dist[j] == INF ? "INF" : String.valueOf(dist[j]), seen.contains(j) ? "already" : "not");
                if (seen.contains(j)) {
                    continue;
                }
                if (here == -1 || dist[here] > dist[j]) {
                    here = j;
                }
            }

            seen.add(here);
            System.out.printf("\nchoosing node %d, time: %d\n\n", here, dist[here]);

            System.out.println("query weight with Web API");
            for (int there : G.neighbours(here)) {
                int w = webApi.getWeight(here, there);
                if (dist[there] > dist[here] + w) {
                    dist[there] = dist[here] + w;
                    pre[there] = here;
                }
            }
            System.out.println();
        }

        displayPath(pre, S, T);

        System.out.println("Earlist arrival time is " + dist[T]);
    }

    private static void displayPath(int[] pre, int S, int T) {
        List<String> path = new ArrayList<>();

        for (int u = T; u != S; u = pre[u]) {
            path.add(String.valueOf(u));
        }
        path.add(String.valueOf(S));

        Collections.reverse(path);

        System.out.println(String.join(" -> ", path));
    }
}