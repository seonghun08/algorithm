import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main0508 {

    public static int solution(int n, int m, int[] arr) {
        int answer = 0;
        Queue<Person> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            q.offer(new Person(i, arr[i]));
        }
        while (!q.isEmpty()) {
            Person p1 = q.poll();
            for (Person p2 : q) {
                if (p2.priority > p1.priority) {
                    q.offer(p1);
                    p1 = null;
                    break;
                }
            }
            if (p1 != null) {
                answer++;
                if (p1.id == m) return answer;
            }
        }
        return answer;
    }

    static class Person {

        int id;
        int priority;

        public Person(int id, int priority) {
            this.id = id;
            this.priority = priority;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(solution(n, m, arr));
    }
}
