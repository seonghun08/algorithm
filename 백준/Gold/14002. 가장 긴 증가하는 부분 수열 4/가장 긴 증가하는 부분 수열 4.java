import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

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
            Answer answer = solution(n, arr);
            bw.write(answer.maxLength + "\n");
            for (int i : answer.lis) {
                bw.write(i + " ");
            }
            bw.flush();
        }
    }

    public static Answer solution(int n, int[] arr) {
        Answer answer = new Answer();
        int[] dp = new int[n];
        int[] prev = new int[n]; // 수열 이전 인덱스 추적 배열
        int lastIdx = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            prev[i] = -1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j; // 변경 시 dp와 함께 이전 인덱스 초기화
                }
            }
            if (dp[i] > answer.maxLength) {
                answer.maxLength = dp[i];
                lastIdx = i; // 최대 값일 때 마지막 인덱스 초기화
            }
        }
        while (lastIdx != -1) {
            answer.lis.add(arr[lastIdx]);
            lastIdx = prev[lastIdx];
        }
        Collections.reverse(answer.lis);
        return answer;
    }

    static class Answer {
        int maxLength = 1; // default 1
        List<Integer> lis = new ArrayList<>();
    }
}