import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Main0605 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(solution3(arr));
    }

    public static char solution3(int[] arr) {
        Arrays.sort(arr);
        int tmp = -1;
        for (int i : arr) {
            if (tmp == i) return 'D';
            tmp = i;
        }
        return 'U';
    }

    public static char solution2(int[] arr) { // best
        HashSet<Integer> set = new HashSet<>();
        for (int n : arr) {
            if (!set.add(n)) { // 중복된 값이 있다면 add() -> false 반환
                return 'D';
            }
        }
        return 'U';
    }

    public static char solution(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : arr) {
            map.put(n, map.getOrDefault(n, 0) + 1);
            if (map.get(n) > 1) {
                return 'D';
            }
        }
        return 'U';
    }
}
