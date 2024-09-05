import java.util.Scanner;

public class Main01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        char c = sc.next().charAt(0);
        System.out.println(solution(s, c));
    }

    public static int solution(String s, char c) {
        int answer = 0;
        char[] chs = s.toUpperCase().toCharArray();
        for (char ch : chs) {
            if (ch == Character.toUpperCase(c)) {
                answer++;
            }
        }
        return answer;
    }
}
