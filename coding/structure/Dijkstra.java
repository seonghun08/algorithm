package structure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Dijkstra {

    static final int INF = Integer.MAX_VALUE;
    static int[] dist;

    public static void dijkstra(int start, List<List<Node>> graph, int n) {
        dist = new int[n + 1];
        Arrays.fill(dist, INF); // 모든 거리를 무한대로 초기화
        dist[start] = 0; // 시작점은 거리 0

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.distance - b.distance);
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            // 가장 거리가 짧은 노드 꺼내기
            Node cur = pq.poll();
            int curIdx = cur.index;
            int curDist = cur.distance;

            // 꺼낸 거리가 이미 저장된 거리보다 크다면 이미 처리된 노드이기 때문에 생략
            if (curDist > dist[curIdx]) continue;

            // 현재 노드와 연결된 인접 노드 확인
            for (Node nd : graph.get(curIdx)) {
                int cost = dist[curIdx] + nd.distance;
                if (dist[nd.index] > cost) {
                    dist[nd.index] = cost;
                    pq.offer(new Node(nd.index, cost));
                }
            }
        }
    }

    public static void main(String[] args) {
        int n = 5; // 노드 개수
        int start = 1; // 시작 노드

        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        graph.get(1).add(new Node(2, 2));
        graph.get(1).add(new Node(3, 5));
        graph.get(1).add(new Node(4, 1));
        graph.get(2).add(new Node(3, 3));
        graph.get(2).add(new Node(4, 2));
        graph.get(3).add(new Node(4, 3));
        graph.get(3).add(new Node(5, 1));
        graph.get(4).add(new Node(5, 1));

        dijkstra(start, graph, n);

        for (int i = 1; i <= n; i++) {
            System.out.println(i + "번 노드까지의 거리: " + (dist[i] == INF ? "INF" : dist[i]));
        }
    }

    static class Node {
        int index;
        int distance;

        Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }
    }
}