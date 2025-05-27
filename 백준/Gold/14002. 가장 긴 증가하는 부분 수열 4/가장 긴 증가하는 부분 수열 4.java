import java.io.*;
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
            bw.write(answer.maxLength + "");
            bw.newLine();
            for (int a : answer.lis) {
                bw.write(a + " ");
            }
            bw.flush();
        }
    }
    
    public static Answer solution(int n, int[] arr) {
        Answer answer = new Answer();
        int[] dp = new int[n];
        int[] prev = new int[n]; // 이전 원소 추적 index 배열
        int lastIdx = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            prev[i] = -1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j; // dp index > 이전 index 저장
                }
            }
            if (dp[i] > answer.maxLength) {
                answer.maxLength = dp[i];
                lastIdx = i;
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
        int maxLength = 1;
        List<Integer> lis = new ArrayList<>();
    }
}