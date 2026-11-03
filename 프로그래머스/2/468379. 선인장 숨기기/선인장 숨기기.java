import java.util.ArrayDeque;
import java.util.Deque;

class Solution {

    public int[] solution(int m, int n, int h, int w, int[][] drops) {

        // 1. 각 칸에 비가 내리는 순서 기록
        int[][] rain = new int[m][n];

        for (int i = 0; i < drops.length; i++) {
            int r = drops[i][0];
            int c = drops[i][1];

            rain[r][c] = i + 1;
        }

        // 비를 맞지 않은 칸은 가장 늦은 시점으로 처리
        int maxTime = drops.length + 1;

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (rain[r][c] == 0) {
                    rain[r][c] = maxTime;
                }
            }
        }

        // 2. 각 행에서 너비 w인 구간의 최솟값 계산
        int widthCount = n - w + 1;
        int[][] horizontal = new int[m][widthCount];

        for (int r = 0; r < m; r++) {
            Deque<Integer> deque = new ArrayDeque<>();
            for (int c = 0; c < n; c++) {
                // 현재 값보다 크거나 같은 이전 후보 제거
                while (!deque.isEmpty() && rain[r][deque.peekLast()] >= rain[r][c]) {
                    deque.pollLast();
                }
                deque.offerLast(c);
                // 구간에서 벗어난 인덱스 제거
                while (!deque.isEmpty() && deque.peekFirst() <= c - w) {
                    deque.pollFirst();
                }
                // 길이 w인 구간이 완성된 경우
                if (c >= w - 1) {
                    horizontal[r][c - w + 1] = rain[r][deque.peekFirst()];
                }
            }
        }

        // 3. 각 열에서 높이 h인 구간의 최솟값 계산
        int[] answer = new int[2];
        int bestTime = -1;

        for (int c = 0; c < widthCount; c++) {
            Deque<Integer> deque = new ArrayDeque<>();
            for (int r = 0; r < m; r++) {
                // 현재 값보다 크거나 같은 이전 후보 제거
                while (!deque.isEmpty() && horizontal[deque.peekLast()][c] >= horizontal[r][c]) {
                    deque.pollLast();
                }
                deque.offerLast(r);
                // 구간에서 벗어난 인덱스 제거
                while (!deque.isEmpty() && deque.peekFirst() <= r - h) {
                    deque.pollFirst();
                }
                // 높이 h인 구간이 완성된 경우
                if (r >= h - 1) {
                    int topRow = r - h + 1;
                    int currentTime =horizontal[deque.peekFirst()][c];
                    // 4. 최적의 구역 선택
                    if (currentTime > bestTime
                        || (currentTime == bestTime && topRow < answer[0])
                        || (currentTime == bestTime && topRow == answer[0] && c < answer[1])
                    ) {
                        bestTime = currentTime;
                        answer[0] = topRow;
                        answer[1] = c;
                    }
                }
            }
        }
        return answer;
    }
}