import java.util.*;

class Solution {
    public int solution(int[][] signals) {
        int time = 0;
        int size = signals.length;
        List<Signal> list = new ArrayList<>();
        
        for (int i = 0; i < size; i++) {
            int signal[] = signals[i];
            list.add(new Signal(
                signal[0],
                signal[0] + signal[1], 
                signal[0] + signal[1] + signal[2]
            ));
        }
        
        // 모든 경우의 수가 안 맞는다면 어떻게 찾을 것인지?
        while (time < 100_000_000) {
            boolean flag = true;
            for (Signal s : list) {
                char curSignal = s.changeTime(time);
                if (flag && curSignal != 'y') flag = false;
            }
            if (flag) return time;
            time++;
        }
        return -1;
    }
    
    static class Signal {
        
        int g, y, r;
        char cur = 'g'; // 최초는 초록불로 시작
        
        public char changeTime(int time) {
            time %= r;
            if (time <= g) {
                return this.cur = 'g';
            } 
            if (time <= y) {
                return this.cur = 'y';
            }
            return this.cur = 'r';
        }
        
        public Signal(int g, int y, int r) {
            this.g = g;
            this.y = y;
            this.r = r;
        }
    }
}