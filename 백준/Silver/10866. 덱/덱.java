import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Deque<Integer> deque = new Deque<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String command = sc.next();
            switch (command) {
                case "push_front":
                    deque.addFirst(sc.nextInt());
                    break;
                case "push_back":
                    deque.addLast(sc.nextInt());
                    break;
                case "pop_front":
                    Integer front = deque.removeFirst();
                    sb.append(front != null ? front : -1).append("\n");
                    break;
                case "pop_back":
                    Integer back = deque.removeLast();
                    sb.append(back != null ? back : -1).append("\n");
                    break;
                case "size":
                    sb.append(deque.size()).append("\n");
                    break;
                case "empty":
                    sb.append(deque.isEmpty() ? 1 : 0).append("\n");
                    break;
                case "front":
                    Integer peekFront = deque.peekFirst();
                    sb.append(peekFront != null ? peekFront : -1).append("\n");
                    break;
                case "back":
                    Integer peekBack = deque.peekLast();
                    sb.append(peekBack != null ? peekBack : -1).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }

    static class Node<T> {

        private final T data;
        private Node<T> next;
        private Node<T> prev;

        public Node(T data) {
            this.data = data;
        }
    }

    static class Deque<T> {

        private Node<T> first;
        private Node<T> last;
        private int size;

        public Deque() {
            this.first = null;
            this.last = null;
            this.size = 0;
        }

        public void addFirst(T data) {
            Node<T> node = new Node<>(data);
            if (first != null) {
                node.next = first;
                first.prev = node;
            }
            first = node;
            if (last == null) {
                last = node;
            }
            size++;
        }

        public void addLast(T data) {
            Node<T> node = new Node<>(data);
            if (last != null) {
                node.prev = last;
                last.next = node;
            }
            last = node;
            if (first == null) {
                first = node;
            }
            size++;
        }

        public T removeFirst() {
            if (first == null) {
                return null;
            }
            T data = first.data;
            first = first.next;
            if (first != null) {
                first.prev = null;
            } else {
                last = null;
            }
            size--;
            return data;
        }

        public T removeLast() {
            if (last == null) {
                return null;
            }
            T data = last.data;
            last = last.prev;
            if (last != null) {
                last.next = null;
            } else {
                first = null;
            }
            size--;
            return data;
        }

        public T peekFirst() {
            if (first == null) {
                return null;
            }
            return first.data;
        }

        public T peekLast() {
            if (last == null) {
                return null;
            }
            return last.data;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public int size() {
            return size;
        }
    }
}
