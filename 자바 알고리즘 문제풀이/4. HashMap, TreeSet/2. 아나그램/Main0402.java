import java.util.*;

public class Main0402 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        System.out.println(solution(s1, s2));
    }

    public static String solution(String s1, String s2) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : s1.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (char ch : s2.toCharArray()) {
            if (!map.containsKey(ch) || map.get(ch) == 0) return "NO";
            map.put(ch, map.get(ch) - 1);
        }
        return "YES";
    }
}
