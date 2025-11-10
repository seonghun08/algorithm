import java.util.*;

public class Main0606 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int a : solution(n, arr)) {
            System.out.print(a + " ");
        }
    }

    public static List<Integer> solution(int n, int[] arr) {
        List<Integer> list = new ArrayList<>();
        int[] clone = arr.clone();
        Arrays.sort(clone);
        for (int i = 0; i < n; i++) {
            if (clone[i] != arr[i]) {
                list.add(i + 1);
            }
        }
        return list;
    }

    public static List<Integer> solution2(int n, int[] arr) {
        List<Person> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Person(i, arr[i]));
        }
        list.sort((a, b) -> {
            if (a.height == b.height) return a.seq - b.seq;
            return a.height - b.height;
        });
        int first = -1;
        int last = -1;
        for (int i = 0; i < n; i++) {
            if (i != list.get(i).seq) {
                if (first == -1) first = i;
                last = i;
            }
        }
        List<Integer> answer = new ArrayList<>();
        answer.add(first + 1);
        answer.add(last + 1);
        return answer;
    }

    static class Person {
        int seq;
        int height;
        public Person(int seq, int height) {
            this.seq = seq;
            this.height = height;
        }
        public String toString() {
            return "seq:" + seq + ", height:" + height;
        }
    }
}
