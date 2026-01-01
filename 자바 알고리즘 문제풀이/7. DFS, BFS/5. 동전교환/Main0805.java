import java.util.*;

public class Main0805 {

    static int n, m;
    static int[] coins;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }
        m = sc.nextInt();

        // 1. dfs 풀이
        Arrays.sort(coins); // 정렬 후 가장 큰 동전부터 돌려야 시간 초과 발생 X
        dfs(0, 0);
        System.out.println(answer);

        // 2. bfs 풀이
        answer = bfs(coins, m);
        System.out.println(answer);

        // 3. dp 풀이
        answer = dp();
        System.out.println(answer);
    }

    public static void dfs(int size, int sum) {
        if (size >= answer) return;
        if (sum > m) return;
        if (sum == m) {
            answer = Math.min(answer, size);
        } else {
            for (int i = n - 1; i >= 0; i--) { // 정렬 후 역순 (큰 동전부터)
                dfs(size + 1, sum + coins[i]);
            }
        }
    }

    public static int bfs(int[] arr, int m) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[m + 1];
        q.offer(0);
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                int n = q.poll();
                if (n == m) {
                    return answer;
                }
                for (int x = 0; x < arr.length; x++) {
                    int nx = n + arr[x];
                    if (nx <= m && !visited[nx]) {
                        visited[nx] = true;
                        q.offer(nx);
                    }
                }
            }
            answer++;
        }
        return -1;
    }

    public static int dp() {
        int[] dp = new int[m + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i : coins) {
            dp[i] = 1;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 0; j < n; j++) {
                if (i > coins[j]) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                    // System.out.printf("%d = min(dp[%d], dp[%d-coins[%d]]+1);\n", dp[i], i, i, j);
                }
            }
        }
        return dp[m] != Integer.MAX_VALUE ? dp[m] : -1;
    }
}
