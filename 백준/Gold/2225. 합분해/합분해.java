import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static final long MOD = 1_000_000_000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        System.out.print(solution(n, k));
    }

    public static long solution(int n, int k) {
        long[][] dp = new long[k + 1][n + 1];

        Arrays.fill(dp[1], 1); // dp[1][1 ~ n] = 0
        for (int i = 1; i <= k; i++) {
            dp[i][0] = 1; // dp[1 ~ k][0] = 0
        }

        for (int i = 2; i <= k; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                dp[i][j] %= MOD;
            }
        }

        return dp[k][n];
    }
}