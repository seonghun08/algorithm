import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        StringBuilder result = new StringBuilder();
        StringBuilder wordBuffer = new StringBuilder();
        boolean flag = false;

        for (char ch : input.toCharArray()) {
            if (ch == '<') {
                result.append(reverse(wordBuffer));
                wordBuffer.setLength(0);
                flag = true;
                result.append(ch);
            } else if (ch == '>') {
                flag = false;
                result.append(ch);
            } else if (flag) {
                result.append(ch);
            } else if (ch == ' ') {
                result.append(reverse(wordBuffer));
                wordBuffer.setLength(0);
                result.append(ch);
            } else {
                wordBuffer.append(ch);
            }
        }

        if (wordBuffer.length() > 0) {
            result.append(reverse(wordBuffer));
        }

        System.out.println(result);
    }

    public static StringBuilder reverse(StringBuilder sb) {
        int lt = 0;
        int rt = sb.length() - 1;
        char[] chs = sb.toString().toCharArray();
        while (lt < rt) {
            char tmp = chs[lt];
            chs[lt] = chs[rt];
            chs[rt] = tmp;
            lt++;
            rt--;
        }
        sb.setLength(0);
        sb.append(chs);
        return sb;
    }
}
