import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(solution(sc.next()));
    }

    public static int solution(String s) {
        int answer = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push('(');
            } else { // s.charAt(i) == ')'
                stack.pop();
                if (s.charAt(i - 1) == '(') { // 레이저인 경우
                    answer += stack.size();
                } else { // 레이저가 아닌 경우
                    answer++;
                }
            }
        }
        return answer;
    }
}
