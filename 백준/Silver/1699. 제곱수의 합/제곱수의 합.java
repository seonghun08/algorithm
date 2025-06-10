import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n + 1]; // dp[i]: i를 제곱수들의 합으로 표현할 때 최소 항 개수
        for (int i = 1; i <= n; i++) {
            dp[i] = i; // 최악의 경우: 1^2을 i번 사용하는 경우 (예: 4 = 1+1+1+1) 최대 항 개수로 설정
            for (int j = 1; j * j <= i; j++) {
                if (dp[i] > dp[i - j * j] + 1) { // j * j 는 항의 수가 1 이기 때문에 빼면 나머지 +1을 더해 비교
                    dp[i] = dp[i - j * j] + 1; // 더 적을 경우 값 초기화
                }
            }
        }
        System.out.print(dp[n]);
    }
}
