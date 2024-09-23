import java.util.*;

public class Main0607 {

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        // implements Comparable<Point>
        // @Override
        // public int compareTo(Point p) {
        //     if (this.x == p.x) return this.y - p.y;
        //     else return this.x - p.x;
        // }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<Point> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            list.add(new Point(x, y));
        }

        list.sort((a, b) -> {
            if (a.x == b.x) return a.y - b.y;
            else return a.x - b.x;
        });

        for (Point p : list) {
            System.out.println(p.x + " " + p.y);
        }
    }
}
