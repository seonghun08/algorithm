import java.util.Scanner;

public class Main {

    private static int[] stack;
    private static int size = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();
        stack = new int[n];

        for (int i = 0; i < n; i++) {
            switch (sc.next()) {
                case "push":
                    push(sc.nextInt());
                    break;
                case "pop":
                    sb.append(pop()).append("\n");
                    break;
                case "size":
                    sb.append(size()).append("\n");
                    break;
                case "empty":
                    sb.append(empty()).append("\n");
                    break;
                case "top":
                    sb.append(top()).append("\n");
                    break;
            }
        }

        System.out.println(sb); // answer
    }

    public static void push(int item) {
        stack[size++] = item;
    }

    public static int pop() {
        if (size == 0) return -1;
        return stack[--size];
    }

    public static int size() {
        return size;
    }

    public static int empty() {
        return size == 0 ? 1 : 0;
    }

    public static int top() {
        if (size == 0) return -1;
        return stack[size - 1];
    }
}
