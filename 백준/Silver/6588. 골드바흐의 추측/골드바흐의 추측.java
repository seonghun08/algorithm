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

            StringBuilder sb = new StringBuilder();
            boolean[] isPrime = new boolean[MAX + 1];
            Arrays.fill(isPrime, true);
            isPrime[0] = isPrime[1] = false;

            for (int i = 2; i * i <= MAX; i++) {
                if (isPrime[i]) {
                    for (int j = i * i; j <= MAX; j += i) {
                        isPrime[j] = false;
                    }
                }
            }

            Integer line;
            while ((line = Integer.parseInt(br.readLine())) != 0) {
                for (int i = 3; i < line; i++) {
                    if (isPrime[i] && isPrime[line - i]) {
                        sb.append(line).append(" = ").append(i).append(" + ").append(line - i).append("\n");
                        break;
                    }
                }
            }

            bw.write(sb.toString());
            bw.flush();
        }
    }
}
