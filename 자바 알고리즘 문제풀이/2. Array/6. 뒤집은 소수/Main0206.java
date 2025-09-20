import java.util.*;

public class Main0206 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        List<Integer> answer = solution(n, arr);
        for (int a : answer) {
            System.out.print(a + " ");
        }
    }

    public static List<Integer> solution(int n, int[] arr) {
        List<Integer> list = new ArrayList<>();
        boolean[] isPrime = getPrime(100_000);
        for (int num : arr) {
            int reverse = reverse(num);
            if (isPrime[reverse]) {
                list.add(reverse);
            }
        }
        return list;
    }

    public static boolean[] getPrime(int size) {
        boolean[] isPrime = new boolean[size + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i * i <= size; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= size; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        return isPrime;
    }

    public static int reverse(int num) {
        int rs = 0;
        while (num > 0) {
            int tmp = num % 10;
            rs = rs * 10 + tmp;
            num /= 10;
        }
        return rs;
    }
}