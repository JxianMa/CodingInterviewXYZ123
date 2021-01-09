package DataStructure.Heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

public class Heap {
    List<Integer> list;
    private Comparator<Integer> comparator;

    Heap(Comparator comparator) {
        this.comparator = comparator;
        this.list = new ArrayList<>();
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    private void swap(List<Integer> list, int i, int j) {
        int tmp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, tmp);
    }

    private int getLeftChildIdx(int idx) {
        return idx * 2 + 1;
    }

    private int getRightChildIdx(int idx) {
        return idx * 2 + 2;
    }

    private int getParentIdx(int idx) {
        return (idx - 1) / 2;
    }

    private void siftUp() {
        int i = list.size() - 1;
        while (i > 0 && comparator.compare(list.get(i), list.get(getParentIdx(i))) < 0) {
            swap(list, i, getParentIdx(i));
            i = getParentIdx(i);
        }
    }

    private void siftDown() {
        int i = 0;
        while (getLeftChildIdx(i) < list.size() && comparator.compare(list.get(i), list.get(getLeftChildIdx(i))) > 0 ||
                getRightChildIdx(i) < list.size() && comparator.compare(list.get(i), list.get(getRightChildIdx(i))) > 0) {
            int greaterIdx = getRightChildIdx(i) < list.size()
                    && comparator.compare(list.get(i), list.get(getRightChildIdx(i))) > 0
                    && comparator.compare(list.get(getRightChildIdx(i)), list.get(getLeftChildIdx(i))) < 0
                    ? getRightChildIdx(i)
                    : getLeftChildIdx(i);
            swap(list, i, greaterIdx);
            i = greaterIdx;
        }
    }

    public void add(int num) {
        list.add(num);
        siftUp();
    }

    public int poll() {
        if (list.size() == 0) throw new NoSuchElementException("Heap is empty");
        int ret = list.get(0);
        swap(list, 0, list.size() - 1);
        list.remove(list.size() - 1);
        siftDown();
        return ret;
    }

    public int peek() {
        if (list.size() == 0) throw new NoSuchElementException("Heap is empty");
        return list.get(list.size() - 1);
    }

    public static void main(String[] args) {
        int[] test1 = {22, 3, 1, 7, 5, 2, 9, 32, 44};
        Heap minHeap = new Heap(new Comparator<Integer>() {
            public int compare(Integer i1, Integer i2) {
                return i1 - i2;
            }
        });
        for (int i : test1) {
            minHeap.add(i);
        }
        while (!minHeap.isEmpty()) {
            System.out.print(minHeap.poll() + ", ");
        }
        System.out.println();

        int[] test2 = {0};
        for (int i : test2) {
            minHeap.add(i);
        }
        while (!minHeap.isEmpty()) {
            System.out.print(minHeap.poll() + ", ");
        }
        System.out.println();

        int[] test3 = {0, 0, 1, 1, 2, 2, 4, 4, 3, 3, 7, 7, 6, 6, 10};
        for (int i : test3) {
            minHeap.add(i);
        }
        while (!minHeap.isEmpty()) {
            System.out.print(minHeap.poll() + ", ");
        }
    }
}
