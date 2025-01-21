import java.util.Collections;
import java.util.Scanner;
import java.util.Arrays;

public class Main0805 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        // System.out.println(solution1(n, m, arr));
        System.out.println(solution2(n, m, arr));
    }

    // dp
    public static int solution1(int n, int m, int[] arr) {
        int[] dp = new int[m + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i : arr) {
            dp[i] = 1;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 0; j < n; j++) {
                if (i > arr[j]) {
                    dp[i] = Math.min(dp[i], dp[i - arr[j]] + 1);
                }
            }
        }
        return dp[m];
    }

    // dfs
    static Integer[] intArr;
    static int min = Integer.MAX_VALUE;
    static int nn, mm;

    public static int solution2(int n, int m, int[] arr) {
        nn = n;
        mm = m;
        intArr = Arrays.stream(arr)
                .boxed()
                .toArray(Integer[]::new);
        Arrays.sort(intArr, Collections.reverseOrder());
        dfs(0, 0);
        return min != Integer.MAX_VALUE ? min : -1;
    }

    public static void dfs(int size, int sum) {
        if (sum > mm) {
            return;
        }
        if (size >= min) {
            return;
        }
        if (sum == mm) {
            min = Math.min(min, size);
        } else {
            for (int i = 0; i < nn; i++) {
                dfs(size + 1, sum + intArr[i]);
            }
        }
    }
}
