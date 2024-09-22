import java.util.Scanner;

public class Main0604 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int a : solution(s, arr)) {
            System.out.print(a + " ");
        }
    }

    public static int[] solution(int s, int[] arr) {
        int[] cache = new int[s];
        for (int n : arr) {
            int pos = -1;
            for (int i = 0; i < s; i++) {
                if (n == cache[i]) {
                    pos = i;
                }
            }
            LRU(pos, n, cache);
        }
        return cache;
    }

    public static void LRU(int pos, int n, int[] cache) {
        int idx = pos == -1 ? cache.length - 1 : pos;
        for (int i = idx; i >= 1; i--) {
            cache[i] = cache[i - 1];
        }
        cache[0] = n;
    }
}