import java.util.*;

public class Main0208 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int a : solution(arr)) {
            System.out.print(a + " ");
        }
    }

    public static int[] solution(int[] arr) {
        int[] answer = new int[arr.length];
        Arrays.fill(answer, 1);
        for (int num : arr) {
            for (int j = 0; j < arr.length; j++) {
                if (num > arr[j]) {
                    answer[j]++;
                }
            }
        }
        return answer;
    }
}