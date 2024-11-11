import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();

        stack.push(10);
        stack.push(20);
        System.out.println("Top of the stack: " + stack.peek());  // Should print 20
        stack.pop();
        System.out.println("Top of the stack after pop: " + stack.peek());  // Should print 10
    }

    static class Stack<E> {
        private LinkedList<E> list = new LinkedList<>();

        public E peek() {
            if (list.isEmpty()) {
                throw new NoSuchElementException("Stack is empty");
            }
            return list.getHead();
        }

        public void push(E value) {
            list.insertFirst(value);
        }

        public E pop() {
            if (list.isEmpty()) {
                throw new NoSuchElementException("Stack is empty");
            }
            return list.removeFirst();
        }
    }

    static class Node<E> {
        E value;
        Node<E> next;

        Node(E value) {
            this.value = value;
            this.next = null;
        }
    }

    static class LinkedList<E> {
        private Node<E> head;
        private int elements = 0;

        public LinkedList() {
            this.head = null;
        }

        public E getHead() {
            if (head == null) {
                throw new NoSuchElementException("List is empty!");
            }
            return head.value;
        }

        public void insertFirst(E value) {
            Node<E> newNode = new Node<>(value);
            newNode.next = head;
            head = newNode;
            elements++;
        }

        public E removeFirst() {
            if (head == null) {
                throw new NoSuchElementException("List is empty!");
            }
            E value = head.value;
            head = head.next;
            elements--;
            return value;
        }

        public boolean isEmpty() {
            return elements == 0;
        }
    }
}
