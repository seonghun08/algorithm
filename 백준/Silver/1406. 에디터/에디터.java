import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        int m = sc.nextInt();

        Stack<Character> leftStack = new Stack<>();
        Stack<Character> rightStack = new Stack<>();

        for (char ch : s.toCharArray()) {
            leftStack.push(ch);
        }

        for (int i = 0; i < m; i++) {
            String cmd = sc.next();
            switch (cmd.charAt(0)) {
                case 'L':
                    if (!leftStack.isEmpty()) {
                        rightStack.push(leftStack.pop());
                    }
                    break;
                case 'D':
                    if (!rightStack.isEmpty()) {
                        leftStack.push(rightStack.pop());
                    }
                    break;
                case 'B':
                    if (!leftStack.isEmpty()) {
                        leftStack.pop();
                    }
                    break;
                case 'P':
                    char ch = sc.next().charAt(0);
                    leftStack.push(ch);
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (char ch : leftStack) {
            sb.append(ch);
        }
        while (!rightStack.isEmpty()) {
            sb.append(rightStack.pop());
        }

        System.out.println(sb.toString());
        sc.close();
    }
}
