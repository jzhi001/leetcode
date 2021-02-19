import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Homework4{

    /**
     * Input format:
     * First line contains a number N, which represents total number of points.
     * For the next N lines, each line contains 2 numbers x and y, 
     * which represents a point (x, y).
     * 
     */
    public static void main(String[] args) {

        // new RandomTest(1, 16).run();
        
        final Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        List<Point> points = new ArrayList<>();

        for(int i = 0; i < n; i++){
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            points.add(new Point(x, y));
        }

        double dc = divideAndConquer(points);
        double bf = bruteForce(points);

        if(dc != bf){
            throw new RuntimeException(String.format("brute force: %.2f, divide and conquer: %.2f\n", bf, dc));
        }

        System.out.printf("%.2f\n", dc);
    }

    static class Point{
        private int x;
        private int y;

        Point(int x, int y){
            this.x = x;
            this.y = y;
        }

        int x(){
            return this.x;
        }

        int y(){
            return this.y;
        }

        @Override
        public String toString() {
            return String.format("(%d, %d)", x, y);
        }

        @Override
        public boolean equals(Object obj) {
            if(obj instanceof Point){
                Point t = (Point)obj;
                return t.x == this.x && t.y == y;
            }else{
                return false;
            }
        }
    }

    static class Pair<T>{
        T first;
        T second;

        Pair(T first, T second){
            this.first = first;
            this.second = second;
        }
    }

    public static double divideAndConquer(List<Point> points){

        Collections.sort(points, Comparator.comparingInt(Point::x).thenComparingInt(Point::y));
        return divideAndConquer(points, 0, points.size() - 1);
    }

    public static double divideAndConquer(List<Point> points, int L, int R) {
        
        if(L >= R){
            return Double.POSITIVE_INFINITY;
        }

        int mid = (L + R) / 2;
        double midx = points.get(mid).x();

        double delta1 = divideAndConquer(points, L, mid);
        double delta2 = divideAndConquer(points, mid + 1, R);

        double ans = Math.min(delta1, delta2);

        final double curMinDist = ans;
        List<Point> pointsInMid = points.subList(L, R + 1)
                                        .stream()
                                        .sorted(Comparator.comparingInt(Point::y))
                                        .filter(pt -> Math.abs(pt.x() - midx) <= curMinDist)
                                        .collect(Collectors.toList());

        final int scanNum = 7;

        for(int i = 0; i < pointsInMid.size(); i++){
            for(int j = i + 1, k = 0; j < pointsInMid.size() && k < scanNum; j++, k++){
                Point a = pointsInMid.get(i);
                Point b = pointsInMid.get(j);

                if(b.y() - a.y() > ans){
                    continue;
                }

                double dist = distance(a, b);

                ans = Math.min(ans, dist);
            }
        }

        return ans;
    }

    public static double bruteForce(List<Point> points) {

        int n = points.size();

        double ans = Double.MAX_VALUE;

        for(int i = 0; i < n - 1; i++){
            for(int j = i + 1; j < n; j++){
                ans = Math.min(ans, distance(points.get(i), points.get(j)));
            }
        }

        return ans;
    }

    public static double distance(Point a, Point b){
        double dx = a.x() - b.x();
        double dy = a.y() - b.y();
        return Math.sqrt(dx * dx + dy * dy);
    }

    static class RandomTest{

        int cases;
        int boundary = 1000;
        int totalPoints = 20;
        Random random = new Random();

        private List<Point> points;

        RandomTest(int cases, int totalPoints){
            this.cases = cases;
            this.totalPoints = totalPoints;
        }

        private void prepare(){
            
            Set<Point> st = new HashSet<>();

            for(int i = 0; i < totalPoints; i++){

                Point pt = generatPoint();

                while(st.contains(pt)){
                    pt = generatPoint();
                }

                st.add(pt);
            }

            this.points = new ArrayList<>(st);
        }

        private Point generatPoint(){
            int x = random.nextInt(boundary);
            int y = random.nextInt(boundary);
            return new Point(x, y);
        }

        public void test(){

            prepare();

            System.out.println(points);

            double bf = bruteForce(points);

            System.out.println("brute force: " + bf);

            double dc = divideAndConquer(points);

            System.out.println("divide and conquer: " + dc);

            if(dc != bf){
                System.err.println(points);
                throw new RuntimeException(String.format("brute force: %.2f, divide and conquer: %.2f\n", bf, dc));
            }
        }

        public void run(){

            for(int i = 0; i < cases; i++){
                test();
            }
        }
    }
}