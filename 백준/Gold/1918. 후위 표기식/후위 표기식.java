import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            String s = br.readLine();
            Deque<Character> stack = new ArrayDeque<>();
            StringBuilder sb = new StringBuilder();

            for (char ch : s.toCharArray()) {
                if (Character.isAlphabetic(ch)) {
                    sb.append(ch);
                } else if (ch == '(') {
                    stack.push(ch);
                } else if (ch == ')') {
                    while (!stack.isEmpty() && stack.peek() != '(') {
                        sb.append(stack.pop());
                    }
                    stack.pop();
                } else {
                    while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(ch)) {
                        sb.append(stack.pop());
                    }
                    stack.push(ch);
                }
            }

            while (!stack.isEmpty()) {
                sb.append(stack.pop());
            }

            bw.write(sb.toString());
            bw.flush();
        }
    }

    private static int precedence(char ch) {
        if (ch == '+' || ch == '-') {
            return 1;
        } else if (ch == '*' || ch == '/') {
            return 2;
        }
        return 0;
    }
}
