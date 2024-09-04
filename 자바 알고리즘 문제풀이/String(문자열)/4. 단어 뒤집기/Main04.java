import java.util.Scanner;

public class Main04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.next();
        }
        //solution(arr);
        //solution2(arr);
        solution3(arr);
    }

    public static void solution(String[] arr) {
        for (String s : arr) {
            StringBuilder sb = new StringBuilder(s);
            sb.reverse();
            System.out.println(sb);
        }
    }

    public static void solution2(String[] arr) {
        for (String s : arr) {
            for (int i = s.length() - 1; i >= 0; i--) {
                System.out.print(s.charAt(i));
            }
            System.out.println();
        }
    }

    public static void solution3(String[] arr) {
        for (String s : arr) {
            char[] chs = s.toCharArray();
            int lt = 0, rt = s.length() - 1;
            while (lt < rt) {
                char tmp = chs[lt];
                chs[lt] = chs[rt];
                chs[rt] = tmp;
                lt++;
                rt--;
            }
            System.out.println(chs);
        }
    }
}
