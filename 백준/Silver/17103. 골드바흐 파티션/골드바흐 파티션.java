import java.io.*;
import java.util.*;

public class Main {

    public static final int MAX = 1_000_000;

    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            int t = Integer.parseInt(br.readLine());

            boolean[] isPrime = getIsPrimeArrays(MAX);
            StringBuilder sb = new StringBuilder();
            String line;

            while ((line = br.readLine()) != null) {
                int cnt = 0;
                int n = Integer.parseInt(line);
                for (int i = 2; i <= n / 2; i++) {
                    if (isPrime[i] && isPrime[n - i]) cnt++;
                }
                sb.append(cnt).append("\n");
            }

            bw.write(sb.toString());
            bw.flush();
        }
    }

    public static boolean[] getIsPrimeArrays(int size) {
        boolean[] isPrime = new boolean[size + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        // 에라토스테네스의 체
        for (int i = 2; i * i < size; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= size; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        return isPrime;
    }
}
