import java.util.Arrays;
import java.util.Scanner;

public class Main0608 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(solution(m, arr));
    }

    public static int solution(int m, int[] arr) {
        Arrays.sort(arr);
        int lt = 0, rt = arr.length;
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (arr[mid] == m) {
                return mid + 1;
            } else if (arr[mid] > m) {
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }
        return -1;
    }
}

