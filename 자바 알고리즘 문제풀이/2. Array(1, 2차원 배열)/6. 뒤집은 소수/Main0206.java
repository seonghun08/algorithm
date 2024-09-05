import java.util.*;

public class Main0206 {
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

    public static List<Integer> solution(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int n : arr) {
            int num = reverse(n);
            if (isPrime(num)) {
                list.add(num);
            }
        }
        return list;
    }

    public static boolean isPrime(int num) {
        if (num == 1) return false;
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int reverse(int n) {
        int num = 0;
        while (n > 0) {
            int tmp = n % 10;
            num = num * 10 + tmp;
            n /= 10;
        }
        return num;
    }
}