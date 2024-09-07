import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main0302 {
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
        for (int a : solution2(n, m, arr1, arr2)) {
            System.out.print(a + " ");
        }
    }

    public static List<Integer> solution(int n, int m, int[] arr1, int[] arr2) {
        List<Integer> answer = new ArrayList<>();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (arr1[i] > arr2[j]) {
                j++;
            } else {
                if (arr1[i] == arr2[j]) {
                    answer.add(arr1[i]);
                    j++;
                }
                i++;
            }
        }
        return answer;
    }

    public static List<Integer> solution2(int n, int m, int[] arr1, int[] arr2) {
        List<Integer> answer = new ArrayList<>();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        for (int i = 0; i < n; i++) {
            if (Arrays.binarySearch(arr2, arr1[i]) >= 0) {
                answer.add(arr1[i]);
            }
        }
        return answer;
    }
}
