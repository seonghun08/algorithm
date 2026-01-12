import java.util.*;

public class Main0810 {

    private static final int[] dx = {0, 0, -1, 1, -1, 1, 1, -1};
    private static final int[] dy = {1, -1, 0, 0, 1, 1, -1, -1};

    public int solution(int[][] island) {
        int count = 0;
        int n = island.length;
        Deque<Pos> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (island[i][j] == 1) {
                    count++;
                    q.offer(new Pos(i, j));
                    bfs(q, island, n);
                }
            }
        }
        return count;
    }

    private void bfs(Deque<Pos> q, int[][] island, int n) {
        while (!q.isEmpty()) {
            Pos p = q.poll();
            for (int k = 0; k < 8; k++) {
                int nx = p.x + dx[k];
                int ny = p.y + dy[k];
                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                if (island[nx][ny] == 0) continue;
                island[nx][ny] = 0;
                q.offer(new Pos(nx, ny));
            }
        }
    }

    private void dfs(int x, int y, int[][] island, int n) {
        island[x][y] = 0;
        for (int k = 0; k < 8; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
            if (island[nx][ny] == 0) continue;
            dfs(nx, ny, island, n);
        }
    }

    static class Pos {
        final int x, y;
        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Main0810 main = new Main0810();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] island = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                island[i][j] = sc.nextInt();
            }
        }
        int answer = main.solution(island);
        System.out.print(answer);
    }
}