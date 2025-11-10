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

    public static int[] solution(int s, int n, int[] arr) {
        int[] cache = new int[s];
        for (int i = 0; i < n; i++) {
            int pos = -1;
            for (int j = 0; j < s; j++) {
                if (arr[i] == cache[j]) {
                    pos = j;
                    break;
                }
            }
            pos = pos == -1 ? s - 1 : pos;
            for (int j = pos; j >= 1; j--) {
                cache[j] = cache[j - 1];
            }
            cache[0] = arr[i];
        }
        return cache;
    }

    public static int[] solution(int size, int[] arr) {
        int[] cache = new int[size];
        for (int n : arr) {
            int pos = -1;
            for (int i = 0; i < size; i++) {
                if (n == cache[i]) {
                    pos = i;
                    break;
                }
            }
            if (pos == -1) {
                for (int i = size - 1; i >= 1; i--) {
                    cache[i] = cache[i - 1];
                }
            } else {
                for (int i = pos; i >= 1; i--) {
                    cache[i] = cache[i - 1];
                }
            }
            cache[0] = n;
        }
        return cache;
    }
}
