import java.util.Scanner;

/**
 * <pre>
 * 중복순열 (DFS 사용)
 * 1 부터 N 까지 번호가 적인 표가 있습니다.
 * 이 중 중복을 허락하여 M번 뽑아 일렬로 나열하는 방법을 모두 출력합니다.
 * </pre>
 */
public class Main0804 {

    static int[] pm;
    static int n, m;

    public static void dfs(int len) {
        if (len == m) {
            StringBuilder sb = new StringBuilder();
            for (int x : pm) {
                sb.append(x).append(" ");
            }
            System.out.println(sb);
        } else {
            for (int i = 1; i <= n; i++) {
                pm[len] = i;
                dfs(len + 1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        pm = new int[m];
        dfs(0);
    }
}