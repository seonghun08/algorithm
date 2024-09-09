import java.util.*;

public class Main07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        // System.out.println(solution(s));
        System.out.println(solution2(s));
    }

    public static String solution(String s) {
        List<Character> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (!list.contains(ch)) {
                sb.append(ch);
            }
            list.add(ch);
        }
        return String.valueOf(sb);
    }

    public static String solution2(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (i == s.indexOf(s.charAt(i))) {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}