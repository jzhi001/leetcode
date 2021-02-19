import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Homework4{

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

    /**
     * Input format:
     * First line contains a number N, which represents total number of points.
     * For the next N lines, each line contains 2 numbers x and y, 
     * which represents a point (x, y).
     * 
     */
    public static void main(String[] args) {
        
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
    }

    public static double divideAndConquer(List<Point> points) {

        int n = points.size();
        
        if(n <= 1){
            return Double.POSITIVE_INFINITY;
        }

        Collections.sort(points, Comparator.comparingInt(Point::x));

        double L = verticalSeperateLine(points);

        double delta1 = divideAndConquer(points.subList(0, n / 2));
        double delta2 = divideAndConquer(points.subList(n / 2, n));

        double ans = Math.min(delta1, delta2);

        final double curMinDist = ans;
        List<Point> pointsInMid = points.stream()
                                        .filter(pt -> Math.abs(pt.x() - L) <= curMinDist)
                                        .sorted(Comparator.comparingInt(Point::y))
                                        .collect(Collectors.toList());

        
        final int x = 7;

        for(int i = 0; i < pointsInMid.size() - x; i++){
            for(int j = i + 1; j < pointsInMid.size(); j++){
                Point a = pointsInMid.get(i);
                Point b = pointsInMid.get(j);
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

    public static double verticalSeperateLine(List<Point> points) {
        
        int n = points.size();

        if(n % 2 == 0){
            Point a = points.get(n / 2 - 1);
            Point b = points.get(n / 2);

            return ((double)a.x() + b.x()) / 2;
        }else{
            Point mid = points.get(n / 2);
            return mid.x();
        }
    }

    public static double distance(Point a, Point b){
        double dx = a.x() - b.x();
        double dy = a.y() - b.y();
        return Math.sqrt(dx * dx + dy * dy);
    }
}