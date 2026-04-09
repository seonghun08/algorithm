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
		
		for (int time = 1; time < maxTime; time++) {
			boolean isYellow = true;
			for (int i = 0; i < size; i++) {
				int g = signals[i][0];
				int y = signals[i][1];
				int cycle = cycles[i];
				int curTime = (time - 1) % cycle + 1;
				if (curTime <= g || curTime > g + y) {
					isYellow = false;
					break;
				}
			}
			if (isYellow) return time;
		}
        return -1;
    }
	
	private int gcd(int a, int b) {
		if (b == 0) return a;
		return gcd(b, a % b);
	}
	
	private int lcm(int a, int b) {
		return a / gcd(a, b) * b;
	}
}