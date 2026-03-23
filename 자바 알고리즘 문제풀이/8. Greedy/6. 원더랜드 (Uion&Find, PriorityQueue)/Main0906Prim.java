import java.util.*;

public class Main0906Prim {

    public int solution(List<List<Edge>> graph) {
        int answer = 0;
        boolean[] ch = new boolean[graph.size() + 1];
        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        pq.offer(new Edge(1, 0));

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();

            if (ch[cur.vex]) continue;

            ch[cur.vex] = true;
            answer += cur.cost;

            for (Edge e : graph.get(cur.vex)) {
                if (ch[e.vex]) continue;
                pq.offer(new Edge(e.vex, e.cost));
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Main0906Prim main = new Main0906Prim();
        Scanner sc = new Scanner(System.in);

        int v = sc.nextInt();
        int e = sc.nextInt();
        List<List<Edge>> graph = new ArrayList<>();

        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < e; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int cost = sc.nextInt();
            graph.get(v1).add(new Edge(v2, cost));
            graph.get(v2).add(new Edge(v1, cost));
        }

        int answer = main.solution(graph);
        System.out.println(answer);
    }

    static class Edge {

        int vex;
        int cost;

        public Edge(int vex, int cost) {
            this.vex = vex;
            this.cost = cost;
        }
    }
}
