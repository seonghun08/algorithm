import java.util.Scanner;

public class Main {
    /**
     * push X: 정수 X를 큐에 넣는 연산이다.
     * pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
     * size: 큐에 들어있는 정수의 개수를 출력한다.
     * empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
     * front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
     * back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MyQueue q = new MyQueue();
        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String command = sc.next();

            if (command.equals("push")) {
                int item = sc.nextInt();
                q.push(item);
            } else {
                int rs;
                switch (command) {
                    case "pop":
                        rs = q.pop();
                        break;
                    case "size":
                        rs = q.size();
                        break;
                    case "empty":
                        rs = q.isEmpty();
                        break;
                    case "front":
                        rs = q.front();
                        break;
                    case "back":
                        rs = q.back();
                        break;
                    default:
                        rs = -1;
                }
                sb.append(rs).append("\n");
            }
        }
        System.out.println(sb);
    }
}

class MyQueue {
    private Node first;
    private Node last;
    private int size;

    public MyQueue() {
        first = null;
        last = null;
        size = 0;
    }

    public void push(int item) {
        Node node = new Node(item);
        if (last != null) {
            last.next = node;
        }
        last = node;
        if (first == null) {
            first = last;
        }
        size++;
    }

    public int pop() {
        if (first == null) return -1;
        int data = first.data;
        first = first.next;
        if (first == null) {
            last = null;
        }
        size--;
        return data;
    }

    public int size() {
        return size;
    }

    public int isEmpty() {
        return first == null ? 1 : 0;
    }

    public int front() {
        if (first == null) {
            return -1;
        }
        return first.data;
    }

    public int back() {
        if (last == null) {
            return -1;
        }
        return last.data;
    }

    static class Node {
        private final int data;
        private Node next;

        public Node(int item) {
            data = item;
        }
    }
}