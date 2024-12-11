import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            int t = Integer.parseInt(br.readLine());  // 테스트 케이스 수

            // 테스트 케이스마다 처리
            for (int i = 0; i < t; i++) {
                String[] input = br.readLine().split(" ");
                int n = Integer.parseInt(input[0]);  // 숫자의 개수
                int[] arr = new int[n];

                // 숫자 배열 입력 받기
                for (int j = 0; j < n; j++) {
                    arr[j] = Integer.parseInt(input[j + 1]);
                }

                long gcdSum = 0;

                // 모든 쌍의 GCD 계산
                for (int j = 0; j < n; j++) {
                    for (int k = j + 1; k < n; k++) {
                        gcdSum += gcd(arr[j], arr[k]);
                    }
                }

                // 결과 출력
                bw.write(gcdSum + "\n");
            }

            bw.flush();
        }
    }

    // 유클리드 알고리즘을 이용한 GCD 계산
    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
