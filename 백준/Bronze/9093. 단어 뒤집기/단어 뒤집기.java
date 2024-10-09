import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            String[] line = str.split(" ");
            for (String s : line) {
                char[] chs = s.toCharArray();
                int lt = 0, rt = s.length() - 1;
                while (lt < rt) {
                    char tmp = chs[lt];
                    chs[lt] = chs[rt];
                    chs[rt] = tmp;
                    lt++;
                    rt--;
                }
                sb.append(new String(chs)).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
        sc.close();
    }
}
