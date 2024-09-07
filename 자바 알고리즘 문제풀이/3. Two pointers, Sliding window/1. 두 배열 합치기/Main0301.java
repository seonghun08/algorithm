import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main0301 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr1 = new int[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int[] arr2 = new int[m];
        for (int i = 0; i < m; i++) {
            arr2[i] = sc.nextInt();
        }
        for (int a : solution(n, m, arr1, arr2)) {
            System.out.print(a + " ");
        }
    }

    public static List<Integer> solution(int n, int m, int[] arr1, int[] arr2) {
        List<Integer> answer = new ArrayList<>();
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (arr1[i] <= arr2[j]) {
                answer.add(arr1[i++]);
            } else {
                answer.add(arr2[j++]);
            }
        }
        while (i < n) answer.add(arr1[i++]);
        while (j < m) answer.add(arr2[j++]);
        return answer;
    }
}
