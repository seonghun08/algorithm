import java.util.Scanner;

public class Main0807 {

    static int n, r;
    static int[][] dy = new int[34][34];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        r = sc.nextInt();
        System.out.println(dfs(n, r));
    }

    public static int dfs(int n, int r) {
        if (dy[n][r] > 0) {
            return dy[n][r];
        }
        if (n == r || r == 0) {
            return 1;
        } else {
            // [n]C[r] = [n-1]C[r-1] + [n-1]C[r]
            return dy[n][r] = dfs(n - 1, r) + dfs(n - 1, r - 1);
        }
    }
}
