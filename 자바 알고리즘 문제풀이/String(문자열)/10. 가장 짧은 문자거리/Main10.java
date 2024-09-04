import java.util.*;

public class Main10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t = sc.next();
        for (int n : solution(s, t)) {
            System.out.print(n + " ");
        }
    }

    public static int[] solution(String s, String t) {
        int len = s.length();
        int[] answer = new int[len];
        int cnt = len;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == t.charAt(0)) {
                cnt = 0;
            } else {
                cnt++;
            }
            answer[i] = cnt;
        }
        for (int i = len - 1; i >= 0; i--) {
            if (s.charAt(i) == t.charAt(0)) {
                cnt = 0;
            } else {
                cnt++;
            }
            answer[i] = Math.min(cnt, answer[i]);
        }
        return answer;
    }
}