import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final int MAX = 100_000;
    private static final int DIVISOR = 1_000_000_009;

    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            int t = Integer.parseInt(br.readLine());
            int[] arr = new int[t];
            for (int i = 0; i < t; i++) {
                arr[i] = Integer.parseInt(br.readLine());
            }
            for (long a : solution(t, arr)) {
                bw.write(a + "\n");
            }
            bw.flush();
        }
    }

    private static List<Long> solution(int n, int[] arr) {
        List<Long> list = new ArrayList<>();

        // dp[i][j]일 때 i가 4인 경우, j는 수식 마지막에 더하는 값
        // ex) i = 4, j = 1 or 2 or 3
        // dp[4][1] = (1+2+1, 3+1) = 경우의 수 2개
        // dp[4][2] = (x) = 경우의 수 0개
        // dp[4][3] = (1+3) = 경우의 수 1개
        // 총 경우의 수는 dp[4][1] + dp[4][2] + dp[4][3] = 3개
        long[][] dp = new long[MAX + 1][4];
        dp[1][1] = 1; // 1
        dp[2][2] = 1; // 2
        dp[3][1] = 1; // 1+2
        dp[3][2] = 1; // 2+1
        dp[3][3] = 1; // 3

        for (int i = 4; i <= MAX; i++) {
            dp[i][1] = (dp[i - 1][2] + dp[i - 1][3]) % DIVISOR;
            dp[i][2] = (dp[i - 2][1] + dp[i - 2][3]) % DIVISOR;
            dp[i][3] = (dp[i - 3][1] + dp[i - 3][2]) % DIVISOR;
        }

        for (int i : arr) {
            long answer = (dp[i][1] + dp[i][2] + dp[i][3]) % DIVISOR;
            list.add(answer);
        }

        return list;
    }
}
