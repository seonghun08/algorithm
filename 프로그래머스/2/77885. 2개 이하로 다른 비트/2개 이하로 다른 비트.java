class Solution {
    public long[] solution(long[] numbers) {
        int len = numbers.length;
        long[] answer = new long[len];
        for (int i = 0; i < len; i++) {
            answer[i] = findFx(numbers[i]);
        }
        return answer;
    }
    
    private long findFx(long n) {
        if (n % 2 == 0) { // 짝수인 경우 +1
            return n + 1;
        }
        char[] chs = ("0" + toBinary(n)).toCharArray();
        for (int i = chs.length - 1; i >= 0; i--) {
            if (chs[i] == '0') { // 홀수 ex) 1011 -> 1101
                chs[i] = '1';
                chs[i + 1] = '0';
                break;
            }
        }
        return toDigit(String.valueOf(chs));
    }
    
    @Deprecated // 완전탐색 즉, +1로 하나씩 확인하는 방법은 시간 제한 때문에 통과 X
    private long findFx2(long n) {
        String s1 = toBinary(n);
        
        long rs = n + 1;
        long limit = rs + n; 
        
        while (rs <= limit) {
            String s2 = toBinary(rs);
            s1 = adjust(s1, s2); // 비교 비트와 개수가 다른 경우 조정
            int cnt = 0; // 서로 다른 비트 개수
            for (int i = 0; i < s2.length(); i++) {
                if (s1.charAt(i) != s2.charAt(i)) {
                    cnt++;
                }
            }
            if (cnt <= 2) break;
            rs++;
        }
        return rs;
    }
    
    private long toDigit(String s) {
        long rs = 0;
        long tx = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            int n = s.charAt(i) - '0';
            rs = rs + n * tx;
            tx *= 2;
        }
        return rs;
    }
    
    private String toBinary(long n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append(n % 2);
            n /= 2;
        }
        return sb.reverse().toString();
    }
    
    private String adjust(String s1, String s2) {
        StringBuilder sb = new StringBuilder();
        int l = s2.length() - s1.length();
        for (int i = 0; i < l; i++) {
            sb.append("0");
        }
        return sb.append(s1).toString();
    }
}