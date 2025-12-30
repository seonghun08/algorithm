import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main0803 {

    static int n, m;
    static List<Problem> pbs = new ArrayList<>();
    static int max = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 문제 개수
        m = sc.nextInt(); // 제한 시간

        pbs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int score = sc.nextInt();
            int time = sc.nextInt();
            pbs.add(new Problem(score, time));
        }

        dfs(0, 0, 0);
        System.out.println(max);
    }

    public static void dfs(int depth, int scoreSum, int timeSum) {
        if (m > timeSum) return;
        if (depth == n) {
            max = Math.max(max, scoreSum);
        } else {
            dfs(depth + 1, scoreSum + pbs.get(depth).score, timeSum + pbs.get(depth).time);
            dfs(depth + 1, scoreSum, timeSum);
        }
    }

    static class Problem {
        int score;
        int time;
        public Problem(int score, int time) {
            this.score = score;
            this.time = time;
        }
    }
}
