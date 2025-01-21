import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main0805 {

    static int n, m;
    static Integer[] coins;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        coins = new Integer[n];
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }
        m = sc.nextInt();

        // 1. dfs 풀이
        Arrays.sort(coins, Collections.reverseOrder());
        dfs(0, 0);
        System.out.println(answer);

        // 2. dp 풀이
        answer = dp();
        System.out.println(answer);
    }

    public static void dfs(int size, int sum) {
        if (size >= answer) {
            return;
        }
        if (sum > m) {
            return;
        }
        if (sum == m) {
            answer = Math.min(answer, size);
        } else {
            for (int i = 0; i < n; i++) {
                dfs(size + 1, sum + coins[i]);
            }
        }
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
