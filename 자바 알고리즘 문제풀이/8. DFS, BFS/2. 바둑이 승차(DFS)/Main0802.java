import java.util.Scanner;

public class Main0802 {

    static int n, c;
    static int max;

    public static void dfs(int idx, int sum, int[] arr) {
        if (sum > c) {
            return;
        }
        if (idx == n) {
            max = Math.max(max, sum);
        } else {
            dfs(idx + 1, sum + arr[idx], arr);
            dfs(idx + 1, sum, arr);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        c = sc.nextInt();
        n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        dfs(0, 0, arr);
        System.out.print(max);
    }
}
