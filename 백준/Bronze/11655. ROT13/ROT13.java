import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                ch = (char) ('A' + (ch - 'A' + 13) % 26); // 대문자 ROT13
            } else if (Character.isLowerCase(ch)) {
                ch = (char) ('a' + (ch - 'a' + 13) % 26); // 소문자 ROT13
            }
            sb.append(ch);
        }
        System.out.println(sb);
    }
}
