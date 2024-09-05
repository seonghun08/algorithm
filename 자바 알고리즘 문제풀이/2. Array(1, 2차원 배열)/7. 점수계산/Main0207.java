import java.util.*;

public class Main0207 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean[] arr = new boolean[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt() == 1;
        }
        System.out.print(solution(arr));
    }

    public static int solution(boolean[] arr) {
        int answer = 0, stack = 0;
        for (boolean bool : arr) {
            if (bool) {
                answer += ++stack;
            } else {
                stack = 0;
            }
        }
        return answer;
    }
}