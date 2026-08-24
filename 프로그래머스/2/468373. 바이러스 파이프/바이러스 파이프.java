import java.util.*;

class Solution {
    
    int n, k, answer = 0;
    int[][] node;
    
    public int solution(int n, int infection, int[][] edges, int k) {
        this.n = n;
        this.k = k;
        this.node = new int[n + 1][n + 1];
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            int type = edge[2];
            node[x][y] = type;
            node[y][x] = type;
        }
        boolean[] infected = new boolean[n + 1];
        infected[infection] = true;
        dfs(0, infected);
        return this.answer;
    }
    
    private void dfs(int depth, boolean[] infected) {
        if (depth == k) {
            answer = Math.max(answer, count(infected));
        } else {
            for (int type = 1; type <= 3; type++) {
                boolean[] copy = Arrays.copyOf(infected, infected.length);
                bfs(copy, type);
                dfs(depth + 1, copy);
            }
        }
    }
    
    private void bfs(boolean[] infected, int type) {
        Deque<Integer> q = new LinkedList<>();
        for (int i = 1; i < infected.length; i++) {
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
    
    private int count(boolean[] bools) {
        int cnt = 0;
        for (boolean bool : bools) {
            if (bool) cnt++;
        }
        return cnt;
    }
}