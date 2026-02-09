import java.util.*;

import java.util.*;

public class Main0904 {

    public int solution(int[][] arr) {
        int answer = 0;
        int n = arr.length;
        List<Schedule> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(new Schedule(arr[i][0], arr[i][1]));
        }
        list.sort((a, b) -> b.day - a.day);
        // System.out.println(list);

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int maxDay = list.get(0).day;
        int j = 0;

        for (int i = maxDay; i >= 1; i--) {
            for (; j < n; j++) {
                Schedule s = list.get(j);
                if (i > s.day) {
                    break;
                }
                pq.offer(s.money);
            }
            if (!pq.isEmpty()) {
                answer += pq.poll();
            }
        }
        return answer;
    }

    static class Schedule {

        int money;
        int day;

        public Schedule(int money, int day) {
            this.money = money;
            this.day = day;
        }

        @Override
        public String toString() {
            return "\nmoney: " + this.money + " day: " + this.day;
        }
    }

    public static void main(String[] args) {
        Main0904 main = new Main0904();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        int answer = main.solution(arr);
        System.out.print(answer);
    }
}

