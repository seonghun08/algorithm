import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static final int MAX = 11;

    public static void main(String[] args) throws Exception {

        int[] dp = new int[MAX + 1];
        dp[1] = 1; dp[2] = 2; dp[3] = 4;

        for (int i = 4; i <= MAX; i++) {
            dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];
        }

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            int t = Integer.parseInt(br.readLine());

            StringBuilder sb = new StringBuilder();
            String line;

            while ((line = br.readLine()) != null) {
                int n = Integer.parseInt(line);
                sb.append(dp[n]).append("\n");
            }

            bw.write(sb.toString());
            bw.flush();
        }
    }
}
