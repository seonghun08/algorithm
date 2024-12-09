package structure;

import java.util.NoSuchElementException;

/**
 * structure.Deque 직접 구현하기
 *
 * @param <T>
 */
public class Deque<T> {

    private Node<T> first;
    private Node<T> last;
    private int size;

    public Deque() {
        first = null;
        last = null;
        size = 0;
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

    public void addLast(T item) {
        Node<T> node = new Node<>(item);
        if (last != null) {
            last.next = node;
            node.prev = last;
        }
        last = node;
        if (first == null) {
            first = node;
        }
        size++;
    }

    public T removeFirst() {
        if (first == null) {
            throw new NoSuchElementException("structure.Deque is empty");
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
            throw new NoSuchElementException("structure.Deque is empty");
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
            throw new NoSuchElementException("structure.Deque is empty");
        }
        return first.data;
    }

    public T peekLast() {
        if (last == null) {
            throw new NoSuchElementException("structure.Deque is empty");
        }
        return last.data;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    static class Node<T> {

        private final T data;
        private Node<T> next;
        private Node<T> prev;

        public Node(T data) {
            this.data = data;
        }
    }
}
