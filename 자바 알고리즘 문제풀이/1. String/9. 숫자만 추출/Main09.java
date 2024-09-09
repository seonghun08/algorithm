import java.util.*;

public class Main09 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        //System.out.println(solution(s));
        System.out.println(solution2(s));
    }

    public static int solution(String s) {
        s = s.replaceAll("[^0-9]", "");
        return Integer.parseInt(s);
    }

    public static int solution2(String s) {
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if ('0' <= ch && ch <= '9') {
                sb.append(ch);
            }
        }
        return Integer.parseInt(sb.toString());
    }
}