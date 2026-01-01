import java.util.Scanner;

public class Main0802 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        c = sc.nextInt();
        n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        dfs(0, 0, arr);
        System.out.println(answer);
    }

    static int c, n;
    static int answer = 0;

    public static void dfs(int depth, int sum, int[] arr) {
        if (sum > c) return;
        if (depth == n) {
            if (sum > answer) answer = sum;
        } else {
            dfs(depth + 1, sum + arr[depth], arr);
            dfs(depth + 1, sum, arr);
        }
    }
}

