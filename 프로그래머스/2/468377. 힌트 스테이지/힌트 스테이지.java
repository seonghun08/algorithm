import java.util.*;

class Solution {
    
    int max, answer = Integer.MAX_VALUE;
    int[][] cost, hint;
    
    public int solution(int[][] cost, int[][] hint) {
        this.max = cost.length - 1;
        this.cost = cost;
        this.hint = hint;
        int[] boxs = new int[cost.length]; // 스테이지 별 힌트권을 담을 박스
        dfs(0, 0, boxs);
        return this.answer;
    }
    
    private void dfs(int depth, int sum, int[] boxs) {
        if (sum >= answer) return;
        
        int useHint = boxs[depth] > max ? max : boxs[depth];
        sum += cost[depth][useHint]; // 힌트권 개수에 따라 해결 비용 조회
        
        if (depth == max) {
            answer = Math.min(answer, sum);
        } else {
            // 현재 스테이지에서 힌트권을 구매 X
            dfs(depth + 1, sum, boxs);
            
            // 현재 스테이지에서 힌트권을 구매 O
            int[] buy = Arrays.copyOf(boxs, boxs.length);
            for (int i = 1; i < hint[depth].length; i++) {
                buy[hint[depth][i] - 1]++;
            }
            dfs(depth + 1, sum + hint[depth][0], buy);
        }
    }
}