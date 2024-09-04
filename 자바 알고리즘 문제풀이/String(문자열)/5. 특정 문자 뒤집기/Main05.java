import java.util.Scanner;

public class Main05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(solution2(s));
    }

    public static String solution(String s) {
        char[] chs = s.toCharArray();
        int lt = 0, rt = s.length() - 1;
        while (lt < rt) {
            if (Character.isAlphabetic(chs[lt]) &&
                Character.isAlphabetic(chs[rt])) {
                char tmp = chs[lt];
                chs[lt] = chs[rt];
                chs[rt] = tmp;
            }
            lt++;
            rt--;
        }
        return String.valueOf(chs);
    }

    public static String solution2(String s) {
        char[] chs = s.toCharArray();
        int lt = 0, rt = s.length() - 1;
        while (lt < rt) {
            if (!Character.isAlphabetic(chs[lt])) {
                lt++;
            } else if (!Character.isAlphabetic(chs[rt])) {
                rt--;
            } else {
                char tmp = chs[lt];
                chs[lt] = chs[rt];
                chs[rt] = tmp;
                lt++;
                rt--;
            }
        }
        return String.valueOf(chs);
    }
}