import java.util.*;

public class Main0808 {

    static int n, f;
    static int[] b, p;
    static int[][] dy = new int[34][34];
    static boolean[] visited;
    static List<Integer> answer = new ArrayList<>();
    static boolean flag;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        f = sc.nextInt();
        b = new int[n];
        p = new int[n];
        visited = new boolean[n + 1];
        for (int i = 0; i < n; i++) {
            b[i] = combination(n - 1, i);
        }
        dfs(0, 0);
        for (int x : answer) {
            System.out.print(x + " ");
        }
    }

    public static int combination(int n, int r) {
        if (dy[n][r] > 0) {
            return dy[n][r];
        }
        if (n == r || r == 0) {
            return 1;
        }
        return dy[n][r] = // [n]C[r] = [n-1]C[r-1] + [n-1]C[r]
                combination(n - 1, r - 1) + combination(n - 1, r);
    }

    public static void dfs(int depth, int sum) {
        if (flag) {
            return;
        }
        if (depth == n) {
            if (sum == f) {
                for (int x : p) {
                    answer.add(x);
                }
                flag = true;
            }
        } else {
            for (int i = 1; i <= n; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    p[depth] = i;
                    dfs(depth + 1, sum + b[depth] * p[depth]);
                    visited[i] = false;
                }
            }
        }
    }
}
