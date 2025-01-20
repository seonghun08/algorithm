import java.util.Scanner;

public class Main0803 {

    static int n, m;
    static int max;

    public static void dfs(int len, int scoreSum, int timeSum, int[][] arr) {
        if (timeSum > m) {
            return;
        }
        if (len == n) {
            max = Math.max(max, scoreSum);
        } else {
            dfs(len + 1, scoreSum + arr[len][0], timeSum + arr[len][1], arr);
            dfs(len + 1, scoreSum, timeSum, arr);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int[][] arr = new int[n][2]; // [n][0]:score, [n][1]:time
        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        dfs(0, 0, 0, arr);
        System.out.print(max);
    }
}
