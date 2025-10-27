import java.util.*;

public class Main0210 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int answer = solution(arr);
        System.out.print(answer);
    }

    // solution 1
    public static int solution(int[][] arr) {
        int[][] tArr = new int[arr.length + 2][arr.length + 2];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                tArr[i + 1][j + 1] = arr[i][j];
            }
        }
        int answer = 0;
        for (int i = 1; i < arr.length + 1; i++) {
            for (int j = 1; j < arr.length + 1; j++) {
                if (tArr[i][j] > tArr[i + 1][j] &&
                    tArr[i][j] > tArr[i - 1][j] &&
                    tArr[i][j] > tArr[i][j + 1] &&
                    tArr[i][j] > tArr[i][j - 1]) {
                    answer++;
                }
            }
        }
        return answer;
    }

    // solution 2
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static int solution2(int[][] arr) {
        int answer = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                boolean flag = true;
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if (nx >= 0 && nx < arr.length &&
                        ny >= 0 && ny < arr.length &&
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
}