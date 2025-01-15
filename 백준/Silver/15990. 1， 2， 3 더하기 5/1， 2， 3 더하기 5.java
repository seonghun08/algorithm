import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static long [][] dp = new long[100_001][4];
    static long mod = 1_000_000_009;

    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            int t = Integer.parseInt(br.readLine());
            int[] arr = new int[t];

            for (int i = 0; i < t; i++) {
                arr[i] = Integer.parseInt(br.readLine());
            }
            
            StringBuilder sb = new StringBuilder();
            dp[1][1] = dp[2][2] = dp[3][1] = dp[3][2] = dp[3][3] = 1;
            int i = 4;

            for (int n : arr) {
                while (i <= n) {
                    dp[i][1] = (dp[i - 1][2] + dp[i - 1][3]) % mod;
                    dp[i][2] = (dp[i - 2][1] + dp[i - 2][3]) % mod;
                    dp[i][3] = (dp[i - 3][1] + dp[i - 3][2]) % mod;
                    i++;
                }
                long rs = (dp[n][1] + dp[n][2] + dp[n][3]) % mod;
                sb.append(rs).append("\n");
            }

            bw.write(sb.toString());
            bw.flush();
        }
    }
}
