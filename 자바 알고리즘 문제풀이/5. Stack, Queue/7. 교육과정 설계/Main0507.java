import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main0507 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        System.out.println(solution(s1, s2));
    }

    public static String solution(String need, String subjects) {
        Queue<Character> q = new LinkedList<>();
        for (char ch : need.toCharArray()) {
            q.offer(ch);
        }
        for (char subject : subjects.toCharArray()) {
            if (subject == q.peek()) {
                q.poll();
                if (q.isEmpty()) return "YES";
            }
        }
        return "NO";
    }

    public static String solution2(String need, String plan) {
        Queue<Character> q = new LinkedList<>();
        for (char ch : need.toCharArray()) {
            q.offer(ch);
        }
        for (char subject : plan.toCharArray()) {
            if (q.contains(subject)) {
                if (subject != q.poll()) return "NO";
            }
        }
        return "YES";
    }
}