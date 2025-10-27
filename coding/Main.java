import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String answer = solution(s);
        System.out.println(answer);
    }

    public static String solution(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == ')') {
                while (stack.peek() != '(') {
                    stack.pop();
                }
                stack.pop();
            } else {
                stack.add(ch);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char ch : stack) {
            sb.append(ch);
        }
        return sb.toString();
    }
}
