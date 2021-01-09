package DataStructure.LinkedList;

public class LinkedListClient {
    public static void main(String[] args) {
        LinkedList<Integer> myLinkedList = new LinkedList<>();
        myLinkedList.addFirst(1);
        myLinkedList.removeFirst();
        myLinkedList.addLast(2);
        myLinkedList.addLast(3);
        myLinkedList.addLast(4);
        myLinkedList.addFirst(20);
        myLinkedList.addLast(5);

        System.out.println("Current size is: " + myLinkedList.size() + ", Correct Answer is: " + 4);
        while (!myLinkedList.isEmpty()) {
            System.out.println(myLinkedList.removeFirst());
        }
    }
}
