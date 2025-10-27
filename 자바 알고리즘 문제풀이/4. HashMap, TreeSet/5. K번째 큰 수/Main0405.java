import java.util.*;

public class Main0405 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(solution(n, k, arr));
    }

    public static int solution(int n, int k, int[] arr) {
        TreeSet<Integer> sums = new TreeSet<>(Comparator.reverseOrder());
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int t = j + 1; t < n; t++) {
                    sums.add(arr[i] + arr[j] + arr[t]);
                }
            }
        }
        int rank = 0;
        for (int sum : sums) {
            if (++rank == k) return sum;
        }
        return -1;
    }
}
