import java.util.HashMap;
import java.util.Scanner;

public class Main0401 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        System.out.println(solution(n, s));
    }

    public static char solution(int n, String s) {
        char answer = ' ';
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int max = Integer.MIN_VALUE;
        for (char ch : map.keySet()) {
            if (max < map.get(ch)) {
                max = map.get(ch);
                answer = ch;
            }
        }
        return answer;
    }
}
