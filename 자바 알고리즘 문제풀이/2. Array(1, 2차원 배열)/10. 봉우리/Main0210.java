import java.util.*;

public class Main0210 {

    private static final int[] dx = {1, 0, -1, 0};
    private static final int[] dy = {0, 1, 0, -1};

    public static int solution2(int[][] arr) {
        int answer = 0;
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                boolean flag = true;
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if (0 <= nx && nx < len &&
                        0 <= ny && ny < len &&
                        arr[i][j] <= arr[nx][ny]) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    answer++;
                }
            }
        }
        return answer;
    }

    public static int solution(int[][] arr) {
        int answer = 0;
        int[][] mount = new int[arr.length + 2][arr.length + 2];
        for (int i = 1; i < mount.length - 1; i++) {
            System.arraycopy(
                    arr[i - 1], 0, mount[i], 1, mount.length - 1 - 1);
        }
        for (int i = 1; i < mount.length - 1; i++) {
            for (int j = 1; j < mount.length - 1; j++) {
                if (mount[i][j] > mount[i + 1][j] &&
                    mount[i][j] > mount[i - 1][j] &&
                    mount[i][j] > mount[i][j + 1] &&
                    mount[i][j] > mount[i][j - 1]) {
                    answer++;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        // for (int[] a : arr) {
        //     System.out.println(Arrays.toString(a));
        // }
        // System.out.print(solution(arr));
        System.out.print(solution2(arr));
    }
}