import java.util.*;

class Solution {
    public int solution(int[][] signals) {
        int size = signals.length;
        int[] cycles = new int[size];
        int maxTime = 1;
        
        for (int i = 0; i < size; i++) {
            cycles[i] = signals[i][0] + signals[i][1] + signals[i][2];
            maxTime = lcm(maxTime, cycles[i]);
        }
        for (int time = 1; time <= maxTime; time++) {
            boolean allYellow = true;
            for (int i = 0; i < size; i++) {
                int g = signals[i][0];
                int r = signals[i][2];
                int cycle = cycles[i];
                int cur = (time - 1) % cycle + 1;
                if (g >= cur || cur > cycle - r) {
                    allYellow = false;
                    break;
                }
            }
            if (allYellow) return time;
        }
        return -1;
    }
    
    private int lcm(int a, int b) {
        return a / gcd(a, b) * b;
    }
    
    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}