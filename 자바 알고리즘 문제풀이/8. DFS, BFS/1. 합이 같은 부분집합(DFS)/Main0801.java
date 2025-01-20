import java.util.Scanner;

public class Main0801 {

    static int n, total;
    static boolean flag;

    public static void dfs(int len, int sum, int[] arr) {
        if (flag) {
            return;
        }
        if (len == n) {
            if (total / 2 == sum) {
                flag = true;
            }
        } else {
            dfs(len + 1, sum + arr[len], arr);
            dfs(len + 1, sum, arr);
        }
    }

    public static void dp(int n, int[] arr) {
        if (total / 2 != 0) {
            flag = false;
            return;
        }
        int target = total / 2;
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int num : arr) {
            for (int j = target; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }
        flag = dp[target];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            total += arr[i];
        }
        dfs(0, 0, arr);
        // dp(n, arr);
        System.out.print(flag ? "YES" : "NO");
    }
}
