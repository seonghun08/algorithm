import java.util.Scanner;

public class Main0201 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(solution(arr));
    }

    public static int solution(int[] arr) {
        int answer = 0;
        int max = Integer.MIN_VALUE;
        for (int n : arr) {
            if (max < n) {
                answer++;
                max = n;
            }
        }
        return answer;
    }
}