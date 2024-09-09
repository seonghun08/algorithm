import java.util.*;

public class Main06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        // System.out.println(solution(s));
        System.out.println(solution2(s));
    }

    public static String solution(String s) {
        s = s.toUpperCase();
        StringBuilder sb = new StringBuilder(s);
        String reverse = sb.reverse().toString();
        return s.equals(reverse) ? "YES" : "NO";
    }

    public static String solution2(String s) {
        s = s.toUpperCase();
        char[] chs = s.toCharArray();
        int lt = 0, rt = s.length() - 1;
        while (lt < rt) {
            char tmp = chs[lt];
            chs[lt] = chs[rt];
            chs[rt] = tmp;
            lt++;
            rt--;
        }
        return s.equals(String.valueOf(chs)) ? "YES" : "NO";
    }

    public static String solution3(String s) {
        s = s.toUpperCase();
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - 1 - i)) {
                return "NO";
            }
        }
        return "YES";
    }
}