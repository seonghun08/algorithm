import java.util.Scanner;

public class Main0305 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(solution2(n));
    }

    public static int solution(int n) {
        int answer = 0, sum = 0, lt = 1;
        for (int rt = 1; rt <= n / 2 + 1; rt++) {
            sum += rt;
            if (sum == n) answer++;
            while (sum >= n) {
                sum -= lt++;
                if (sum == n) answer++;
            }
        }
        return answer;
    }

    public static int solution2(int n) {
        int answer = 0, cnt = 1;
        n--;
        while (n > 0) {
            n -= ++cnt;
            if (n % cnt == 0) answer++;
        }
        return answer;
    }
}
