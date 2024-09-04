import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 10진법 수
        int b = sc.nextInt(); // B진법

        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            int v = n % b;
            if (v >= 10) {
                sb.append((char) (v + 55));
            } else {
                sb.append(v);
            }
            n /= b;
        }
        System.out.print(sb.reverse());
    }
}
