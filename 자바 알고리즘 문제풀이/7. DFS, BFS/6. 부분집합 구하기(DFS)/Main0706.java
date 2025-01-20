import java.util.Scanner;

public class Main0706 {

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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            total += arr[i];
        }
        dfs(0, 0, arr);
        System.out.print(flag ? "YES" : "NO");
    }
}
