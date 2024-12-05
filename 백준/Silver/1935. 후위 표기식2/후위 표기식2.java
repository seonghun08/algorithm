import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String prefix = br.readLine();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Stack<Double> stack = new Stack<>();

        for (char ch : prefix.toCharArray()) {
            if (Character.isAlphabetic(ch)) {
                stack.push((double) arr[ch - 65]);
            } else {
                double b = stack.pop();
                double a = stack.pop();
                switch (ch) {
                    case '*':
                        stack.push(a * b);
                        break;
                    case '+':
                        stack.push(a + b);
                        break;
                    case '-':
                        stack.push(a - b);
                        break;
                    case '/':
                        stack.push(a / b);
                        break;
                    case '%':
                        stack.push(a % b);
                        break;
                }
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.format("%.2f", stack.pop()));
        bw.flush();
    }
}
