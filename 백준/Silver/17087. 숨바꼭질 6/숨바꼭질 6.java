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
            String[] line = br.readLine().split(" ");
            int n = Integer.parseInt(line[0]);
            int s = Integer.parseInt(line[1]);

            StringTokenizer st = new StringTokenizer(br.readLine());
            int answer = Math.abs(s - Integer.parseInt(st.nextToken()));

            for (int i = 0; i < n - 1; i++) {
                int tmp = Math.abs(s - Integer.parseInt(st.nextToken()));
                answer = gcd(answer, tmp);
            }

            bw.write(String.valueOf(answer));
            bw.flush();
        }
    }

    public static int gcd(int a, int b) {
        while (b != 0) {
            int tmp = b;
            b = a % b;
            a = tmp;
        }
        return a;
    }
}
