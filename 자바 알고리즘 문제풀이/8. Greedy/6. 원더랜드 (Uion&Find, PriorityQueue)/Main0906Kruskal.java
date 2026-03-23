import java.util.*;

public class Main0906Kruskal {

    private int[] unf;

    public int solution(List<Edge> list, int v) {
        unf = new int[v + 1];
        for (int i = 1; i <= v; i++) {
            unf[i] = i;
        }
        list.sort((a, b) -> a.cost - b.cost);

        int answer = 0;
        int cnt = 0;

        for (Edge e : list) {
            int fv1 = find(e.v1);
            int fv2 = find(e.v2);
            if (fv1 != fv2) {
                answer += e.cost;
                cnt++;
                unf[fv1] = fv2;
            }
            if (cnt == v - 1) break;
        }
        return answer;
    }

    private int find(int x) {
        if (unf[x] == x) return x;
        return unf[x] = find(unf[x]);
    }

    public static void main(String[] args) {
        Main0906Kruskal main = new Main0906Kruskal();
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt(); // 도시의 개수
        int e = sc.nextInt(); // 도로의 개수

        List<Edge> list = new ArrayList<>();
        for (int i = 0; i < e; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int cost = sc.nextInt();
            list.add(new Edge(v1, v2, cost));
        }

        int answer = main.solution(list, v);
        System.out.println(answer);
    }

    static class Edge {

        int v1;
        int v2;
        int cost;

        public Edge(int v1, int v2, int cost) {
            this.v1 = v1;
            this.v2 = v2;
            this.cost = cost;
        }
    }
}
