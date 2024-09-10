import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(solution(sc.next()));
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

    }
}
