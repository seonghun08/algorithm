class Solution {
    
    long distLimit, splitLimit;
    long answer = 1;
    
    // 분배노드개수, 현재노드개수, 이전 리프노드확정개수, 이전 분배도
    private void dfs(long distCnt, long curCnt, long leafCnt, long splitScore) {
        if (distCnt > distLimit) {
            return;
        }
        answer = Math.max(answer, curCnt + leafCnt);
        
        // 다음 깊이에 사용할 수 있는 노드를 구한다.
        long useCnt = Math.min(distLimit - distCnt, curCnt);
        for (int child = 2; child <= 3; child++) {
            long nextScore = splitScore * child;
            if (nextScore > splitLimit) {
                continue;
            }
            dfs(
                distCnt + useCnt,
                useCnt * child,
                leafCnt + curCnt - useCnt,
                nextScore
            );
        }
    }
    
    public int solution(int dist_limit, int split_limit) {
        this.distLimit = dist_limit;
        this.splitLimit = split_limit;
        dfs(0, 1, 0, 1);
        return (int) this.answer;
    }
}