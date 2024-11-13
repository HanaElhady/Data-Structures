import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SortedLinkedList<Integer> slinklist = new SortedLinkedList<>();
        slinklist.insert(5);
        slinklist.insert(3);
        slinklist.insert(1);
        slinklist.print();  // 1 3 5
        slinklist.insert(2);
        slinklist.print(); // 1 2 3 5
    }
    static class Node<E> {
        E value;
        Node<E> next;

        Node(E value) {
            this.value = value;
            this.next = null;
        }
    }

    static class SortedLinkedList<E> {
        private Node<E> head;
        private int elements = 0;

        public SortedLinkedList() {
            this.head = null;
        }


        public void insert(E value) {
            if (!(value instanceof Comparable)) {
                throw new IllegalArgumentException("Type E must implement Comparable<E>");
            }

            Node<E> newNode = new Node<>(value);

            // Case 1: Insert at the beginning if the list is empty or newNode is smaller than the head
            if (head == null || ((Comparable<E>) head.value).compareTo(value) >= 0) {
                newNode.next = head;
                head = newNode;
                return;
            }
            Node<E> current = head;
            while (current.next != null && ((Comparable<E>) current.next.value).compareTo(value) < 0) {
                current = current.next;
            }

            newNode.next = current.next;
            current.next = newNode;
        }


        public void print() {
            Node current = head;
            if (head != null) {
                while (current.next != null) {
                    System.out.print(current.value + " ");
                    current = current.next;
                }
                System.out.print(current.value + " ");
                System.out.println();
            }
        }

    }
}
