import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                if ((ch += 13) > 90) {
                    ch = (char) ('A' + (ch - 'Z' - 1));
                }
            } else if (Character.isLowerCase(ch)) {
                if ((ch += 13) > 122) {
                    ch = (char) ('a' + (ch - 'z' - 1));
                }
            }
            sb.append(ch);
        }
        System.out.println(sb);
    }
}
