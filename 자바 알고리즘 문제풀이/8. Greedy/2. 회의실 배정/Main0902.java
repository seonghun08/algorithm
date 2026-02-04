import java.util.*;

public class Main0902 {

    public int solution(int[][] arr) {
        int n = arr.length;
        List<Meet> meets = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            meets.add(new Meet(arr[i][0], arr[i][1]));
        }
        meets.sort((a, b) -> {
            if (a.end != b.end) return a.end - b.end;
            else return a.start - b.start;
        });
        int answer = 0;
        int e = 0;
        for (Meet m : meets) {
            if (m.start >= e) {
                answer++;
                e = m.end;
            }
        }
        return answer;
    }

    static class Meet {
        int start;
        int end;
        Meet(int start, int end) {
            this.start = start;
            this.end = end;
        }
        @Override
        public String toString() {
            return "start: " + this.start + ", end: " + this.end;
        }
    }

    public static void main(String[] args) {
        Main0902 main = new Main0902();
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
