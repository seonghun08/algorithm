import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[m];
        for (int i = 0; i < m; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print(solution(a, b, m, arr));
    }

    public static String solution(int a, int b, int m, int[] arr) {
        int decimal = 0;
        for (int i = 0; i < m; i++) {
            decimal = decimal * a + arr[i];
        }

        if (decimal == 0) return "0";

        StringBuilder sb = new StringBuilder();
        while (decimal != 0) {
            sb.insert(0, (decimal % b) + " ");  // 나머지를 앞에 삽입
            decimal /= b;  // 몫을 다시 저장
        }

        return sb.toString();
    }
}
