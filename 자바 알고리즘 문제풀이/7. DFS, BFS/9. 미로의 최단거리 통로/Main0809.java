import java.util.*;

public class Main0809 {

    private static final int SIZE = 7;
    private static final int[] dx = {0, 1, 0, -1};
    private static final int[] dy = {1, 0, -1, 0};

    public int solution(int[][] arr) {
        Queue<Pos> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[SIZE][SIZE];
        q.offer(new Pos(0, 0));
        visited[0][0] = true;
        int dist = 0;
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                Pos cur = q.poll();
                if (cur.x == SIZE - 1 && cur.y == SIZE - 1) {
                    return dist;
                }
                for (int k = 0; k < 4; k++) {
                    int nx = cur.x + dx[k];
                    int ny = cur.y + dy[k];
                    if (nx < 0 || ny < 0 || nx >= SIZE || ny >= SIZE) continue;
                    if (visited[nx][ny] || arr[nx][ny] == 1) continue;
                    visited[nx][ny] = true;
                    q.offer(new Pos(nx, ny));
                }
            }
            dist++;
        }
        return -1;
    }

    static class Pos {
        final int x, y;
        Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Main0809 main = new Main0809();
        Scanner sc = new Scanner(System.in);
        int[][] arr = new int[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int answer = main.solution(arr);
        System.out.println(answer);
    }
}