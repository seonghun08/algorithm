import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();

        if (n == 0) {
            System.out.println(0);
            return;
        }

        StringBuilder sb = new StringBuilder();

        while (n != 0) {
            int tmp = n % -2; // -2로 나눈 나머지 계산
            n /= -2; // 몫 계산

            // 나머지가 음수일 경우 보정 작업
            if (tmp < 0) {
                tmp += 2;
                n += 1;
            }

            // 나머지를 결과에 추가
            sb.append(tmp);
        }

        // 결과를 역순으로 출력
        System.out.println(sb.reverse());
    }
}
