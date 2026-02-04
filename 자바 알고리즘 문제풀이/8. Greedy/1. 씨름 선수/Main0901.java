import java.util.*;

public class Main0901 {

    public int solution(int n, int[][] arr) {
        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            persons.add(new Person(arr[i][0], arr[i][1]));
        }
        persons.sort((a, b) -> b.height - a.height);
        int answer = 0;
        int max = 0;
        for (Person p : persons) {
            if (p.weight > max) {
                answer++;
                max = p.weight;
            }
        }
        return answer;
    }

    static class Person {
        int height;
        int weight;
        Person(int height, int weight) {
            this.height = height;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        Main0901 main = new Main0901();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        int answer = main.solution(n, arr);
        System.out.print(answer);
    }
}
