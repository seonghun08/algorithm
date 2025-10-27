import java.util.*;

public class Main0403 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int a : solution(n, k, arr)) {
            System.out.print(a + " ");
        }
    }

    public static List<Integer> solution(int n, int k, int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        list.add(map.size());

        int lt = 0;
        for (int rt = k; rt < n; rt++) {
            if (map.get(arr[lt]) == 1) {
                map.remove(arr[lt]);
            } else {
                map.put(arr[lt], map.get(arr[lt]) - 1);
            }
            lt++;
            map.put(arr[rt], map.getOrDefault(arr[rt], 0) + 1);
            list.add(map.size());
        }
        return list;
    }
}
