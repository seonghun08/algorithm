import java.util.Scanner;
import java.util.Stack;

public class Main0502 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(solution2(sc.next()));
    }

    public static String solution(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                count++;
            } else if (ch == ')') {
                count--;
            } else if (count == 0) {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public static String solution2(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == ')') {
                while (stack.pop() != '(');
            } else {
                stack.push(ch);
            }
        }
        for (char ch : stack) {
            sb.append(ch);
        }
        return sb.toString();
    }
}
