import java.util.*;

public class Main0503 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        int m = sc.nextInt();
        int[] moves = new int[m];
        for (int i = 0; i < m; i++) {
            moves[i] = sc.nextInt();
        }
        System.out.println(solution(board, moves));
    }

    public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for (int m : moves) { // 1, 5, 3, 5, 1, 2, ...
            m--; // 번호와 idx 를 맞추기 위함
            for (int i = 0; i < board.length; i++) {
                if (board[i][m] != 0) {
                    if (!stack.isEmpty() && stack.peek() == board[i][m]) {
                        answer += 2;
                        stack.pop();
                    } else {
                        stack.push(board[i][m]);
                    }
                    board[i][m] = 0;
                    break;
                }
            }
        }
        return answer;
    }
}
