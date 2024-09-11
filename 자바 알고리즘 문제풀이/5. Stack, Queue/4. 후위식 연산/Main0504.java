import java.util.Scanner;
import java.util.Stack;

public class Main0504 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(solution(sc.next()));
    }

    // 352+*9- = 3*(5+2)-9
    public static int solution(String s) {
        Stack<Integer> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                stack.push(ch - '0');
            } else {
                int rt = stack.pop();
                int lt = stack.pop();
                switch (ch) {
                    case '+': stack.push(rt + lt); break;
                    case '-': stack.push(rt - lt); break;
                    case '*': stack.push(rt * lt); break;
                    case '/': stack.push(rt / lt);
                }
            }
        }
        return stack.firstElement();
    }
}
