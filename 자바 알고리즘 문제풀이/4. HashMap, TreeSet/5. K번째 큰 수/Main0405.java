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
        TreeSet<Integer> set = new TreeSet<>((a, b) -> b - a);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int t = j + 1; t < n; t++) {
                    set.add(arr[i] + arr[j] + arr[t]);
                }
            }
        }
        int cnt = 0;
        for (int a : set) {
            if (++cnt == k) return a;
        }
        return -1;
    }
}
