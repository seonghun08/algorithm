import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int n = sc.nextInt(); // 자연수
            if (n == -1) break;
            System.out.println(solution(n));
        }
    }

    public static String solution(int n) {
        int sum = 0;
        Queue<Integer> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < n; i++) {
            if (n % i == 0) {
                sum += i;
                q.offer(i);
            }
        }
        if (sum == n) {
            sb.append(n).append(" = ");
            while (!q.isEmpty()) {
                sb.append(q.poll());
                if (q.peek() != null) {
                    sb.append(" + ");
                }
            }
        }
        return sb.length() > 0 ? sb.toString() : n + " is NOT perfect.";
    }
}