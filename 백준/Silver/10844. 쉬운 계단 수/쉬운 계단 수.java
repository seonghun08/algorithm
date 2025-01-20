import java.util.Scanner;

public class Main {

    private static final int NUM = 10;
    private static final int MOD = 1_000_000_000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        long[][] dp = new long[n + 1][NUM];
        for (int i = 1; i < NUM; i++) {
            dp[1][i] = 1; // 길이가 1이고, 마지막 숫자가 (1~9)인 경우 각각 1개로 총 9개
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < NUM; j++) {
                if (j > 0) {
                    dp[i][j] += dp[i - 1][j - 1];
                }
                if (j < 9) {
                    dp[i][j] += dp[i - 1][j + 1];
                }
                dp[i][j] %= MOD;
            }
        }

        long result = 0;
        for (int j = 0; j < NUM; j++) {
            result += dp[n][j];
        }

        System.out.println(result % MOD);
    }
}
