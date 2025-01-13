import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] arr = new int[n + 1];
            int[] dp = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= n; i++) {
                dp[i] = arr[i];
                for (int j = 1; j < i; j++) {
                    dp[i] = Math.min(dp[i], dp[i - j] + arr[j]);
                    // System.out.printf("dp[%d]=%d%n", i, dp[i]);
                }
            }

            bw.write(dp[n] + "");
            bw.flush();
        }
    }
}
