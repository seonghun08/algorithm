import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(solution(n, arr));
    }

    public static String solution(int n, int[] arr) {
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int p = 1;
        for (int target : arr) {
            while (p <= target) {
                stack.push(p);
                sb.append("+\n");
                p++;
            }
            if (stack.peek() == target) {
                stack.pop();
                sb.append("-\n");
            } else {
                return "NO";
            }
        }
        return sb.toString();
    }
}