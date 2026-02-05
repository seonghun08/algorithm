import java.util.*;

public class Main0811 {

    private int m;
    private List<Point> houses = new ArrayList<>();
    private List<Point> pizzas = new ArrayList<>();
    private int houseSize, pizzaSize;
    private int[][] distMatrix;
    private int answer = Integer.MAX_VALUE;

    public int solution(int m, int[][] arr) {
        this.m = m;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                switch (arr[i][j]) {
                    case 1: houses.add(new Point(i, j)); break;
                    case 2: pizzas.add(new Point(i, j));
                }
            }
        }

        houseSize = houses.size();
        pizzaSize = pizzas.size();
        distMatrix = new int[houseSize][pizzaSize];

        for (int i = 0; i < houseSize; i++) {
            Point h = houses.get(i);
            for (int j = 0; j < pizzaSize; j++) {
                Point p = pizzas.get(j);
                distMatrix[i][j] = Math.abs(h.x - p.x) + Math.abs(h.y - p.y);
            }
        }

        dfs(0, 0, new int[m]);
        return answer;
    }

    private void dfs(int start, int count, int[] combi) {
        if (count == m) {
            findMinDist(combi);
        } else {
            for (int i = start; i < pizzaSize; i++) {
                combi[count] = i;
                dfs(i + 1, count + 1, combi);
            }
        }
    }

    private void findMinDist(int[] combi) {
        int totalSum = 0;
        for (int hIdx = 0; hIdx < houseSize; hIdx++) {
            int min = Integer.MAX_VALUE;
            for (int pIdx : combi) {
                int dist = distMatrix[hIdx][pIdx];
                min = Math.min(min, dist);
            }
            totalSum += min;
            if (totalSum >= answer) return;
        }
        answer = Math.min(answer, totalSum);
    }

    static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Main0811 main = new Main0811();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int answer = main.solution(m, arr);
        System.out.println(answer);
    }
}
