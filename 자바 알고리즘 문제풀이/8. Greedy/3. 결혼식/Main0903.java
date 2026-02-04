import java.util.*;

public class Main0903 {

    public int solution(int n, int[][] arr) {
        List<Time> times = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            times.add(new Time(arr[i][0], arr[i][1]));
        }
        times.sort((a, b) -> a.start - b.start);
        int count = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (Time t : times) {
            while(!q.isEmpty() && q.peek() <= t.start) {
                q.poll();
            }
            q.offer(t.end);
            if (q.size() > count) {
                count = q.size();
            }
        }
        return count;
    }

    static class Time {
        int start, end;
        Time(int start, int end) {
            this.start = start;
            this.end = end;
        }
        @Override
        public String toString() {
            return "start: " + this.start + " end: " + this.end;
        }
    }

    public static void main(String[] args) {
        Main0903 main = new Main0903();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] times = new int[n][2];
        for (int i = 0; i < n; i++) {
            times[i][0] = sc.nextInt();
            times[i][1] = sc.nextInt();
        }
        int answer = main.solution(n, times);
        System.out.print(answer);
    }
}
