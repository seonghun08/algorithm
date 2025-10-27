import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main0404 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t = sc.next();
        System.out.println(solution(s, t));
    }

    public static int solution(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            getOrDefault(map, c);
        }

        Map<Character, Integer> ana = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            getOrDefault(ana, s.charAt(i));
        }

        int answer = isAnagram(map, ana) ? 1 : 0;
        int lt = 0;
        for (int rt = t.length(); rt < s.length(); rt++) {
            ana.put(s.charAt(lt), ana.get(s.charAt(lt)) - 1);
            getOrDefault(ana, s.charAt(rt));
            lt++;
            if (isAnagram(map, ana)) answer++;
        }
        return answer;
    }

    public static void getOrDefault(
            Map<Character, Integer> map,
            char ch
    ) {
        map.put(ch, map.getOrDefault(ch, 0) + 1);
    }

    public static boolean isAnagram(
            Map<Character, Integer> map,
            Map<Character, Integer> ana
    ) {
        for (char ch : map.keySet()) {
            if (!ana.containsKey(ch)) return false;
            if (map.get(ch) != ana.get(ch)) return false;
        }
        return true;
    }

    public static int solution2(String s, String t) {
        int answer = 0;
        int lt = 0, rt = t.length() - 1;

        HashMap<Character, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> tMap = new HashMap<>();

        for (int i = lt; i <= rt; i++) {
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) + 1);
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
        }
        if (sMap.equals(tMap)) answer++;

        while (++rt < s.length()) {
            if (sMap.get(s.charAt(lt)) == 1) {
                sMap.remove(s.charAt(lt));
            } else {
                sMap.put(s.charAt(lt), sMap.get(s.charAt(lt)) - 1);
            }
            lt++;
            sMap.put(s.charAt(rt), sMap.getOrDefault(s.charAt(rt), 0) + 1);
            if (sMap.equals(tMap)) answer++;
        }

        return answer;
    }
}
