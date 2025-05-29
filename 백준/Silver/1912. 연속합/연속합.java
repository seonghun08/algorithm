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
            int[] arr = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            int answer = solution(n, arr);
            bw.write(answer + "");
            bw.flush();
        }
    }

    public static int solution(int n, int[] arr) {
        int[] dp = new int[n];
        System.arraycopy(arr, 0, dp, 0, n);
        int answer = dp[0];
        for (int i = 1; i < n; i++) {
            if (dp[i - 1] > 0) {
                dp[i] += dp[i - 1];
            }
            answer = Math.max(answer, dp[i]);
        }
        return answer;
    }
}