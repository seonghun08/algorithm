import java.util.Scanner;

/**
 * <pre>
 * 10 이하의 N개의 자연수가 주어집니다.
 * 이 중 M개를 뽑아 일렬로 나열하는 방법을 모두 출력합니다.
 *
 * input:
 * 3 2
 * 3 6 9
 *
 * output:
 * 3 6
 * 3 9
 * 6 3
 * 6 9
 * 9 3
 * 9 6
 * </pre>
 */
public class Main0806 {

    static int n, m;
    static int[] arr, chk, pm;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n];
        chk = new int[n];
        pm = new int[m];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        dfs(0);
    }

    public static void dfs(int len) {
        if (len == m) {
            StringBuilder sb = new StringBuilder();
            for (int i : pm) {
                sb.append(i).append(" ");
            }
            System.out.println(sb);
        } else {
            for (int i = 0; i < n; i++) {
                if (chk[i] == 0) {
                    pm[len] = arr[i];
                    chk[i] = 1;
                    dfs(len + 1);
                    chk[i] = 0;
                }
            }
        }
    }
}
