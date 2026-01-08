import java.util.*;

class Solution {
    public long subArrayRanges(int[] nums) {
        long max = sumSubArray(nums, true);
        long min = sumSubArray(nums, false);
        return max - min;
    }

    // 부분 배열 최대 합, 최소 합 찾기
    private long sumSubArray(int[] nums, boolean isMax) {
        int n = nums.length;
        int[] prev = new int[n];
        int[] next = new int[n];

        Deque<Integer> st = new ArrayDeque<>();
        long rs = 0;

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && 
                   compare(nums[st.peek()], nums[i], isMax, true)) {
                st.pop();
            }
            prev[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        st.clear();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && 
                   compare(nums[st.peek()], nums[i], isMax, false)) {
                st.pop();
            }
            next[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        for (int i = 0; i < n; i++) {
            int left = i - prev[i];
            int right = next[i] - i;
            rs += (long) nums[i] * left * right;
        }
        return rs;
    }

    private boolean compare(int a, int b, boolean isMax, boolean isPrev) {
        if (isMax) {
            return isPrev ? a <= b : a < b;
        }
        return isPrev ? a >= b : a > b;
    }
}