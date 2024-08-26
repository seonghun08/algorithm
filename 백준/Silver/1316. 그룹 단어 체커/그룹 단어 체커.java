import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.next();
        }
        System.out.print(solution(arr));
    }

    private static int solution(String[] arr) {
        return Arrays.stream(arr)
                .mapToInt(Main::answer)
                .sum();
    }

    private static int answer(String s) {
        boolean[] alphabet = new boolean[26];
        char[] chs = s.toCharArray();
        char l = ' ';
        for (char c : chs) {
            if (l != c && alphabet[c - 'a']) {
                return 0;
            } else {
                alphabet[c - 'a'] = true;
                l = c;
            }
        }
        return 1;
    }
}