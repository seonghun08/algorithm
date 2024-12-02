import java.util.Scanner;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        List<Integer> list = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            q.offer(i);
        }

        while (!q.isEmpty()) {
            for (int i = 0; i < k - 1; i++) {
                q.offer(q.poll());
            }
            list.add(q.poll());
        }

        String answer = list.toString()
                .replace("[", "<")
                .replace("]", ">");
        System.out.println(answer);
    }
}
