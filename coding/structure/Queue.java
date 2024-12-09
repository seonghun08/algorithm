package structure;

import java.util.NoSuchElementException;

/**
 * structure.Queue 직접 구현하기
 *
 * @param <T>
 */
public class Queue<T> {

    private Node<T> first;
    private Node<T> last;

    static class Node<T> {
        private final T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }

    private int size;

    public Queue() {
        first = null;
        last = null;
        size = 0;
    }

    public void offer(T item) {
        Node<T> node = new Node<>(item);
        if (last != null) {
            node.next = node; // 마지막 노드에 새 노드 연결
        }
        last = node; // 마지막 노드를 기존 마지막 노드에서 새 노드로 변경
        if (first == null) {
            first = node; // 첫 노드가 존재하지 않는다면 새 노드 설정
        }
        size++;
    }

    public T pop() {
        if (first == null) {
            throw new NoSuchElementException("structure.Queue is empty");
        }
        T data = first.data;
        first = first.next; // 첫 노드를 다음 노드로 변경
        if (first == null) {
            last = null; // 첫 노드가 존재하지 않는다면 마지막 노드 null 처리
        }
        size--;
        return data;
    }

    public T peek() {
        if (first == null) {
            throw new NoSuchElementException("structure.Queue is empty");
        }
        return first.data;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return size;
    }
}
