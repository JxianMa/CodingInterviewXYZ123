package DataStructure.LinkedList;

import java.util.NoSuchElementException;

public class LinkedList<T> {
    private class ListNode<T> {
        T item;
        ListNode<T> next;

        ListNode(T item) {
            this.item = item;
        }
    }

    private ListNode<T> first;
    private ListNode<T> last;
    private int cnt;

    public LinkedList() {
        cnt = 0;
        first = null;
        last = null;
    }

    public void addFirst(T item) {
        ListNode<T> newFirst = new ListNode<>(item);
        newFirst.next = first;
        first = newFirst;
        if (last == null) last = first;
        cnt++;
    }

    public void addLast(T item) {
        ListNode<T> newLast = new ListNode<>(item);
        if (last != null) {
            last.next = newLast;
        }
        last = newLast;
        if (first == null) first = last;
        cnt++;
    }

    public T removeFirst() {
        if (first == null) throw new NoSuchElementException("First node does not exist");
        T ret = first.item;
        first = first.next;
        cnt--;
        return ret;
    }

    public T removeLast() {
        if (first == null) return null;
        if (first.next == null) {
            first = null;
            T ret = last.item;
            last = null;
            return ret;
        }

        ListNode<T> secondToLast = first;
        while (secondToLast.next.next != null) {
            secondToLast = secondToLast.next;
        }
        T ret = last.item;
        secondToLast.next = null;
        cnt--;
        return ret;
    }

    public T getFirst() {
        if (first == null) throw new NoSuchElementException("First node does not exist");
        return first.item;
    }

    public T getLast() {
        if (last == null) throw new NoSuchElementException("Last node does not exist");
        return last.item;
    }

    public boolean isEmpty() {
        return cnt == 0;
    }

    public int size() {
        return cnt;
    }
}
