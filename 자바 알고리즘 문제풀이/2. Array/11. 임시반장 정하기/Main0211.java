import java.util.Scanner;

public class Main0211 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][5];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 5; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int answer = solution(n, arr);
        System.out.print(answer);
    }

    public static int solution(int n, int[][] arr) {
        int answer = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                for (int k = 0; k < 5; k++) {
                    if (arr[i][k] == arr[j][k]) {
                        cnt++;
                        break;
                    }
                }
            }
            if (cnt == n) return i + 1;
            if (cnt > max) {
                answer = i;
                max = cnt;
            }
        }
        return answer + 1;
    }
}
