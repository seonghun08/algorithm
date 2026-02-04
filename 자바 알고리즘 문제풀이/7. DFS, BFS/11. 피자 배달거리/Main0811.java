import java.util.*;

public class Main0811 {

    private int m;
    private List<Point> houses = new ArrayList<>();
    private List<Point> pizzas = new ArrayList<>();
    private int[] combi;
    private int answer = Integer.MAX_VALUE;

    public int solution(int m, int[][] map) {
        this.m = m;
        this.combi = new int[m];
        int n = map.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                switch(map[i][j]) {
                    case 1: houses.add(new Point(i, j)); break;
                    case 2: pizzas.add(new Point(i, j));
                }
            }
        }
        dfs(0, 0);
        return answer;
    }

    private void dfs(int start, int count) {
        if (count == m) {
            calculateDistance(); // M개의 피자집을 모두 선택 후, 최소 거리 계산
        } else {
            for (int i = start; i < pizzas.size(); i++) {
                combi[count] = i; // i번째 피자집 선택
                dfs(i + 1, count + 1); // 다음 피자집 선택 (중복 방지를 위해 i + 1)
            }
        }
    }

    private void calculateDistance() {
        int sum = 0;
        for (Point h : houses) {
            int minDist = Integer.MAX_VALUE;
            for (int idx : combi) { // 선택된 M개의 피자집 중 가장 가까운 곳 찾기
                Point p = pizzas.get(idx);
                int dist = Math.abs(h.x - p.x) + Math.abs(h.y - p.y);
                minDist = Math.min(minDist, dist);
            }
            sum += minDist;
        }
        answer = Math.min(answer, sum); // 도시의 전체 거리 중 최솟값 갱신
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
        System.out.print(answer);
    }
}
