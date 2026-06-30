import java.util.*;

class Solution {
    
    static final int[] types = { 1, 2, 3 }; // A(1), B(2), C(3)
    int n, k, max = 0;
    int[][] node;
    
    public int solution(int n, int infection, int[][] edges, int k) {
        this.n = n; // 배양체 개수
        this.k = k; // 최대 행동 수
        this.node = new int[n + 1][n + 1]; // 간선
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            int type = edge[2];
            node[x][y] = type;
            node[y][x] = type;
        }
        boolean[] infected = new boolean[n + 1];
        infected[infection] = true; // 최초 감염체 삽입
        dfs(0, infected);
        return this.max;
    }
    
    private void dfs(int depth, boolean[] infected) {
        if (depth == k) {
            max = Math.max(count(infected), max);
        } else {
            for (int type : types) {
                boolean[] next = Arrays.copyOf(infected, infected.length);
                bfs(type, next);
                dfs(depth + 1, next);
            }
        }
    }
    
    private void bfs(int type, boolean[] infected) {
        Deque<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (infected[i]) q.offer(i);
        }
        while (!q.isEmpty()) {
            int cur = q.poll(); // 감염체
            for (int nx = 1; nx <= n; nx++) {
                // 해당 노드의 파이프가 열려있고, 감염되지 않은 경우 전파
                if (node[cur][nx] == type && !infected[nx]) {
                    infected[nx] = true;
                    q.offer(nx);
                }
            }
        }
    }
    
    private int count(boolean[] bools) {
        int cnt = 0;
        for (boolean bool : bools) {
            if (bool) cnt++;
        }
        return cnt;
    }
}