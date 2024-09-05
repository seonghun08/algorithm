import java.util.Scanner;

public class Main03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        //System.out.println(solution(s));
        System.out.println(solution2(s));
    }

    public static String solution2(String s) {
        String answer = "";
        int max = Integer.MIN_VALUE;
        int pos;

        while ((pos = s.indexOf(' ')) != -1) {
            String tmp = s.substring(0, pos);
            int l = tmp.length();
            if (l > max) {
                max = l;
                answer = tmp;
            }
            s = s.substring(pos + 1);
        }

        return s.length() > max ? s : answer;
    }

    public static String solution(String s) {
        String[] list = s.split(" ");
        int idx = 0;
        for (int i = 1; i < list.length; i++) {
            if (list[idx].length() < list[i].length()) {
                idx = i;
            }
        }
        return list[idx];
    }
}
