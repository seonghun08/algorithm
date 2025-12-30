import java.util.*;

public class Main0708 {

    static int max = 10_000;
    static int[] dis = {1, -1, 5};

    public static int bfs(int s, int e) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[max + 1];

        visited[s] = true;
        q.offer(s);

        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                int n = q.poll();
                if (n == e) { // 현재 좌표가 송아지의 위치와 같다면 종료
                    return answer;
                }
                for (int di : dis) {
                    int nx = n + di;
                    // 해당 좌표에 방문한 적이 없으며, 좌표는 1 ~ 10,000까지
                    if (!visited[nx] && 1 <= nx && nx <= max) {
                        visited[nx] = true; // 해당 좌표 방문 표시
                        q.offer(nx);
                    }
                }
            }
            answer++;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int e = sc.nextInt();
        int answer = bfs(s, e);
        System.out.println(answer);
    }
}
