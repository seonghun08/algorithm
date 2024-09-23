import java.util.*;

public class Main0606 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int a : solution(n, arr)) {
            System.out.print(a + " ");
        }
    }

    public static List<Integer> solution(int n, int[] arr) {
        List<Integer> list = new ArrayList<>();
        int[] clone = arr.clone();
        Arrays.sort(clone);
        for (int i = 0; i < n; i++) {
            if (clone[i] != arr[i]) {
                list.add(i + 1);
            }
        }
        return list;
    }
}
