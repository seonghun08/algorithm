import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main0508 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int answer = solution(m, arr);
        System.out.println(answer);
    }

    public static int solution(int m, int[] arr) {
        Queue<Person> q = new LinkedList<>();
        int answer = 0;
        for (int i = 0; i < arr.length; i++) {
            q.offer(new Person(i, arr[i]));
        }
        while (!q.isEmpty()) {
            Person p1 = q.poll();
            for (Person p2 : q) {
                if (p2.score > p1.score) {
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
        return 0;
    }

    static class Person {
        int id;
        int score;
        public Person(int id, int score) {
            this.id = id;
            this.score = score;
        }
    }
}
