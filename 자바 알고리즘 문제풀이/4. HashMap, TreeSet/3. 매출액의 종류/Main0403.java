import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

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
        List<Integer> answer = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int lt = 0, rt = k - 1;

        for (int i = lt; i <= rt; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        answer.add(map.keySet().size());

        while (++rt < n) {
            if (map.get(arr[lt]) == 1) {
                map.remove(arr[lt]);
            } else {
                map.put(arr[lt], map.get(arr[lt]) - 1);
            }
            lt++;
            map.put(arr[rt], map.getOrDefault(arr[rt], 0) + 1);
            answer.add(map.keySet().size());
        }

        return answer;
    }
}
