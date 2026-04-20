import java.util.*;

public class Main1004 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Wall> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int extent = sc.nextInt();
            int height = sc.nextInt();
            int weight = sc.nextInt();
            list.add(new Wall(extent, height, weight));
        }
        Collections.sort(list);

        int answer = 0;
        int[] dy = new int[n];
        dy[0] = list.get(0).height;

        for (int i = 1; i < n; i++) {
            Wall cur = list.get(i);
            int maxHeight = 0;
            for (int j = i; j >= 0; j--) {
                Wall back = list.get(j);
                if (cur.weight < back.weight) {
                    maxHeight = Math.max(maxHeight, dy[j]);
                }
            }
            dy[i] = maxHeight + cur.height;
            answer = Math.max(answer, dy[i]);
        }
        System.out.println(answer);
    }

    static class Wall implements Comparable<Wall> {

        int extent;
        int height;
        int weight;

        public Wall(int extent, int height, int weight) {
            this.extent = extent;
            this.height = height;
            this.weight = weight;
        }

        @Override
        public int compareTo(Wall w) {
            if (this.extent != w.extent) {
                return w.extent - this.extent;
            }
            return w.weight - this.weight;
        }
    }
}
