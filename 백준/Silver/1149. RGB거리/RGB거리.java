import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = Integer.parseInt(br.readLine());
            int[][] dp = new int[n + 1][3];

            for (int i = 1; i <= n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int r = Integer.parseInt(st.nextToken());
                int g = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + r;
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + g;
                dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + b;
            }

            int answer = Integer.MAX_VALUE;
            for (int i : dp[n]) {
                answer = Math.min(answer, i);
            }
            bw.write(answer + "");
            bw.flush();
        }
    }
}