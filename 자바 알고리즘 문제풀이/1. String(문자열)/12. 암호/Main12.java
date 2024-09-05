import java.util.*;

public class Main12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        System.out.println(solution(s));
    }

    public static String solution(String s) {
        StringBuilder sb = new StringBuilder();
        s = s.replace("#", "1").replace("*", "0");
        while (s.length() >= 7) {
            String tmp = s.substring(0, 7);
            int value = Integer.parseInt(tmp, 2);
            sb.append((char) value);
            s = s.substring(7);
        }
        return sb.toString();
    }
}