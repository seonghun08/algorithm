import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    static int k;
    static char[] signs;
    static boolean[] visited;
    static ArrayList<String> result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();
        signs = new char[k];
        for (int i = 0; i < k; i++) {
            signs[i] = sc.next().charAt(0);
        }
        visited = new boolean[10]; // 0 ~ 9 사용 여부
        result = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            visited[i] = true;
            dfs(i, 0, String.valueOf(i));
            visited[i] = false;
        }

        Collections.sort(result); // 정렬
        System.out.println(result.get(result.size() - 1)); // 최댓값
        System.out.println(result.get(0)); // 최솟값
    }

    // prev: 현재까지 만들어진 숫자 (마지막 자릿수), depth: 부등호의 인덱스, s: 현재까지 만들어진 문자열
    public static void dfs(int prev, int depth, String s) {
        // 종료 조건: k+1 자리의 숫자가 완성되면 결과 리스트에 추가
        if (depth == k) {
            result.add(s);
            return;
        }
        // 다음 자릿수에 올 숫자 탐색 (0부터 9까지)
        for (int next = 0; next < 10; next++) {
            if (visited[next]) continue;
            if (signs[depth] == '>' && prev > next) {
                visited[next] = true;
                dfs(next, depth + 1, s + next);
                visited[next] = false;
            } else if (signs[depth] == '<' && prev < next) {
                visited[next] = true;
                dfs(next, depth + 1, s + next);
                visited[next] = false;
            }
        }
    }
}
