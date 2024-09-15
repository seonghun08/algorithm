import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main0506 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        System.out.println(solution(n, k));
    }

    public static int solution(int n, int k) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            q.offer(i);
        }
        int seq = 1; // 1 ~ k
        while (q.size() > 1) {
            int p = q.poll();
            if (seq++ == k) seq = 1;
            else q.offer(p);
        }
        return !q.isEmpty() ? q.poll() : 0;
    }

    public static int solution2(int n, int k) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            q.offer(i);
        }
        while (!q.isEmpty()) {
            for (int i = 1; i < k; i++) {
                q.offer(q.poll());
            }
            q.poll();
            if (q.size() == 1) {
                answer = q.poll();
            }
        }
        return answer;
    }
}