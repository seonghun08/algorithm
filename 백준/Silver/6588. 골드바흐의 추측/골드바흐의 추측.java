import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    private static final int MAX = 1000000;

    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            // 소수 판별 배열 초기화
            boolean[] isPrime = new boolean[MAX + 1];
            Arrays.fill(isPrime, true);
            isPrime[0] = isPrime[1] = false;

            // 에라토스테네스의 체
            for (int i = 2; i * i <= MAX; i++) {
                if (isPrime[i]) {
                    for (int j = i * i; j <= MAX; j += i) {
                        isPrime[j] = false;
                    }
                }
            }

            StringBuilder sb = new StringBuilder();
            Integer line;

            // 테스트 케이스 처리
            while ((line = Integer.parseInt(br.readLine())) != 0) {
                boolean flag = false;
                // 두 홀수 소수의 합으로 n을 나타낼 수 있는지 확인
                for (int i = 3; i <= line / 2; i++) {
                    int complement = line - i;
                    if (isPrime[i] && isPrime[complement]) {
                        sb.append(line).append(" = ").append(i).append(" + ").append(complement).append("\n");
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    sb.append("Goldbach's conjecture is wrong.").append("\n");
                }
            }

            bw.write(sb.toString());
            bw.flush();
        }
    }
}
