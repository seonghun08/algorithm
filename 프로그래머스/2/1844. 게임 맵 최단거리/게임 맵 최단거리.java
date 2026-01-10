import java.util.*;

class Solution {
    
    private final int[] dx = {0, 1, 0, -1};
    private final int[] dy = {1, 0, -1, 0};
    
    public int solution(int[][] maps) {
        int answer = 1;
        int nSize = maps.length;
        int mSize = maps[0].length;
        
        Deque<Pos> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[nSize][mSize];
        
        q.offer(new Pos(0, 0));
        visited[0][0] = true;
        
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                Pos p = q.poll();
                if (p.x == nSize - 1 && p.y == mSize - 1) {
                    return answer;
                }
                for (int k = 0; k < 4; k++) {
                    int nx = p.x + dx[k];
                    int ny = p.y + dy[k];
                    if (nx >= 0 && ny >= 0 &&
                        nx < nSize && ny < mSize &&
                        !visited[nx][ny] && 
                        maps[nx][ny] == 1) {
                        visited[nx][ny] = true;
                        q.offer(new Pos(nx, ny));
                    }
                }
            }
            answer++;
        }
    
        return -1;
    }
    
    public static class Pos {
        int x;
        int y;
        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}