import java.util.*;

class Solution {
    
    private int n, k, max = 0;
    private int[][] node;
    
    public int solution(int n, int infection, int[][] edges, int k) {
        this.n = n;
        this.k = k;
        this.node = new int[n + 1][n + 1];
        for (int[] e : edges) {
            int x = e[0];
            int y = e[1];
            int type = e[2]; // A(1), B(2), C(3)
            node[x][y] = type;
            node[y][x] = type;
        }
        boolean[] infected = new boolean[n + 1];
        infected[infection] = true; // 최초 감염 배양체
        dfs(0, infected);
        return max;
    }
    
    private void dfs(int depth, boolean[] infected) {
        if (depth == k) {
            max = Math.max(max, count(infected));
        } else {
            for (int type = 1; type <= 3; type++) {
                boolean[] next = Arrays.copyOf(infected, infected.length);
                bfs(type, next); // 감염 전파 spread
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
            int cur = q.poll();
            for (int nx = 1; nx <= n; nx++) {
                if (node[cur][nx] == type && !infected[nx]) {
                    infected[nx] = true;
                    q.offer(nx);
                }
            }
        }
    }
    
    private int count(boolean[] infected) {
        int cnt = 0;
        for (boolean bool : infected) {
            if (bool) cnt++;
        }
        return cnt;
    }
}