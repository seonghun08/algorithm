import java.util.Scanner;

public class Main0303 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(solution2(n, k, arr));
    }

    // Sliding window
    public static int solution2(int n, int k, int[] arr) {
        int answer, sum = 0;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        answer = sum;
        for (int i = k; i < n; i++) {
            sum += (arr[i] - arr[i - k]);
            answer = Math.max(answer, sum);
        }
        return answer;
    }

    // Time limit exceed
    public static int solution(int n, int k, int[] arr) {
        int answer = Integer.MIN_VALUE;
        for (int i = 0; i < n - k; i++) {
            int sum = 0;
            for (int j = i; j < i + k; j++) {
                sum += arr[j];
            }
            if (answer < sum) {
                answer = sum;
            }
        }
        return answer;
    }
}
