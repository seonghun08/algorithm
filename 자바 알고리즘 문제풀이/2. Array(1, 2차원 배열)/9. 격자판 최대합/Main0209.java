import java.util.*;

public class Main0209 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.print(solution(arr));
    }

    public static int solution(int[][] arr) {
        int answer = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            int rowSum = 0, columnSum = 0;
            for (int j = 0; j < arr.length; j++) {
                columnSum += arr[i][j];
                rowSum += arr[j][i];
            }
            answer = Math.max(answer, Math.max(columnSum, rowSum));
        }

        int xSum = 0, ySum = 0;
        for (int i = 0; i < arr.length; i++) {
            xSum += arr[i][i];
            ySum += arr[i][arr.length - 1 - i];
        }
        answer = Math.max(answer, Math.max(xSum, ySum));

        return answer;
    }
}