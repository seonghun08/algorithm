import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {

        // 빠른 입력을 위한 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 배열 크기 입력
        int[] arr = new int[n];
        int[] answer = new int[n];

        // 입력받은 수열 처리
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();

        // 오큰수 계산
        for (int i = n - 1; i >= 0; i--) {
            // 스택에서 현재 값보다 작은 값 제거
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }

            // 스택이 비어 있으면 오큰수 없음 (-1)
            if (stack.isEmpty()) {
                answer[i] = -1;
            } else {
                // 스택의 최상단 값이 오큰수
                answer[i] = stack.peek();
            }

            // 현재 값을 스택에 추가
            stack.push(arr[i]);
        }

        // 빠른 출력을 위한 BufferedWriter
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int a : answer) {
            bw.write(a + " ");
        }
        bw.flush();
    }

    // time out (1 sec)
    public static List<Integer> fail(int n, int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int pos = arr[i];
            int rs = 0;
            for (int j = i + 1; j < n; j++) {
                if (pos < arr[j]) {
                    rs = arr[j];
                    break;
                }
            }
            if (rs != 0) {
                list.add(rs);
            } else {
                list.add(-1);
            }
        }
        return list;
    }
}
