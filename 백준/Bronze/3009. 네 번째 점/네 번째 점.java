import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] points = new int[3][2];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                points[i][j] = sc.nextInt();
            }
        }
        for (int a : solution(points)) {
            System.out.print(a + " ");
        }
    }

    public static int[] solution(int[][] points) {
        int[] xy = new int[2];
        xy[0] = findPoint(points, 0);
        xy[1] = findPoint(points, 1);
        return xy;
    }

    private static int findPoint(int[][] points, int idx) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] point : points) {
            map.put(point[idx], map.getOrDefault(point[idx], 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return -1;
    }
}