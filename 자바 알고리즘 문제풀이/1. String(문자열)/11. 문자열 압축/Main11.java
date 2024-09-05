import java.util.*;

public class Main11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(solution2(s));
    }

    public static String solution(String s) {
        StringBuilder sb = new StringBuilder();
        char tmp = ' ';
        int cnt = 1;
        for (char ch : s.toCharArray()) {
            if (tmp == ch) {
                cnt++;
            } else {
                if (cnt > 1) {
                    sb.append(cnt);
                }
                sb.append(ch);
                cnt = 1;
                tmp = ch;
            }
        }
        if (cnt > 1) {
            sb.append(cnt);
        }
        return sb.toString();
    }

    public static String solution2(String s) {
        s = s + " ";
        int cnt = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                cnt++;
            } else {
                sb.append(s.charAt(i));
                if (cnt > 1) {
                    sb.append(cnt);
                    cnt = 1;
                }
            }
        }
        return sb.toString();
    }
}