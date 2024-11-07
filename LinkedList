
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList linkedList = new LinkedList();
        System.out.println(linkedList.isEmpty());
        linkedList.append(5);
        linkedList.append(10);
        linkedList.append(15);
        linkedList.append(5);
        linkedList.append(10);
        linkedList.append(15);
        linkedList.print();
        linkedList.print(2);
        linkedList.insertFirst(30);
        linkedList.print();
        linkedList.insert(20,2);
        linkedList.print();
        linkedList.insert(50,10);
        System.out.println(linkedList.isEmpty());
        int[] arr = {3, 2, 1};
        linkedList.insertFirst(arr);
        linkedList.print();
        int[] arr1 = {1 , 2 , 3};
        linkedList.append(arr1);
        linkedList.print();
        int[] arr2 = {12 , 23 , 34};
        linkedList.insert(arr2 , 2);
        linkedList.print();
        linkedList.iterateReverse();
        int[] found = linkedList.getFirstLast(12);
        for(int i = 0 ; i < found.length ; i++) {
            System.out.print(found[i]+1 + " ");
        }
        System.out.println();
        System.out.println(linkedList.contains(12));
        linkedList.remove(12);
        linkedList.print();
        linkedList.remove(15);
        linkedList.print();
        linkedList.removeFirst();
        linkedList.print();
        linkedList.removeLast();
        linkedList.print();
        System.out.println(linkedList.getHead());
        System.out.println(linkedList.getTail());
        linkedList.empty();
        linkedList.print();
    }



    static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    static class LinkedList {
        Node head;
        int elements = 0;
        public LinkedList() {
            this.head = null;
        }
        public int getHead() {
            return head.value;
        }
        public int getTail() {
            Node current = head;
            while (current.next.next != null) {
                current = current.next;
            }
            return current.next.value;

        }
        public void append(int value) {
            elements++;
            Node newNode = new Node(value);
            if(head == null ) {
                head = newNode;
            }else {
                Node current = head;
                while (current.next !=null) {
                    current = current.next;
                }
                current.next = newNode;
            }
        }
        public void append(int[] values) {
            elements += values.length;
            Node newNode;
            if (head == null) {
                head = new Node(values[0]);
                newNode = head;
            } else {
                Node current = head;
                while (current.next != null) {
                    current = current.next;
                }
                newNode = current;
            }
            for (int i = (head == newNode) ? 1 : 0; i < values.length; i++) {
                newNode.next = new Node(values[i]);
                newNode = newNode.next;
            }
        }

        public void insertFirst(int value) {
            elements++;
            Node newNode = new Node(value);
            newNode.next = head;
            head = newNode;
        }
        public void insertFirst(int[] arr) {
            elements+=arr.length;
            for(int i = 0 ; i< arr.length ; i ++ ) {
                Node newNode = new Node(arr[i]);
                newNode.next = head;
                head = newNode;
            }
        }
        public void insert(int value , int pos) {
            Node newNode = new Node(value);
            if(elements < pos) {
                System.out.println("lists size is only " + elements);
                return;
            }
            elements++;
            Node place = head;
            for(int i = 1 ; i < pos-1 ; i ++ ) {
                place = place.next;
            }
            newNode.next = place.next;
            place.next = newNode;
        }

        public void insert(int[] values, int pos) {
            if (pos > elements + 1) {
                System.out.println("List size is only " + elements);
                return;
            }
            if (pos == 1) {
                insertFirst(values);
                return;
            }

            elements += values.length;
            Node place = head;

            for (int i = 1; i < pos - 1; i++) {
                place = place.next;
            }
            Node afterPlace = place.next;

            Node newNode = new Node(values[0]);
            place.next = newNode;

            for (int i = 1; i < values.length; i++) {
                newNode.next = new Node(values[i]);
                newNode = newNode.next;
            }
            newNode.next = afterPlace;
        }
        public void iterateReverse() {
            Stack<Node> stack = new Stack<>();
            Node current = head;

            while (current != null) {
                stack.push(current);
                current = current.next;
            }
            System.out.print("Linked List in reverse order: ");
            while (!stack.isEmpty()) {
                Node node = stack.pop();
                System.out.print(node.value + " ");
            }
            System.out.println();
        }
        public int[] getFirstLast(int target){
            Node current = head;
            int first = 0;
            int index = 0;
            int last = 0;
            boolean foundFirst = false;
            while(current.next != null ) {
                if(current.value == target && !foundFirst)  {
                    first = index;
                    foundFirst = true;
                }

                if(current.value == target) last = index;

                current = current.next;
                index++;
            }
            return foundFirst ? new int[]{first , last} : new int[]{-1 , -1} ;
        }
        public boolean contains(int target) {
           int arr[] =  getFirstLast(target);
           return arr[0] != -1;

        }
        public void remove(int target) {
            if(!contains(target)) {
                System.out.println("THERE IS NO SUCH ELEMENT IN THE LIST!!");
            }
            else{
                elements--;
                Node current = head;
                while(current.next != null ) {
                    Node previous = current;
                    current = current.next;
                    if(current.value == target ) {
                        previous.next = current.next;
                        break;
                    }
                }

            }
        }
        public void removeFirst() {
            if(head != null) {
                head = head.next;
            }
            else System.out.println("List is empty!!");
        }
        public void removeLast() {
            if (head == null) {
                System.out.println("List is empty!!");
                return;
            }
            elements--;

            if (head.next == null) {
                head = null;
                return;
            }

            Node current = head;
            while (current.next.next != null) {
                current = current.next;
            }
            current.next = null;
        }
        public void empty() {
            head = null;
            elements = 0;
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

        public void print(int start) {
            Node current = head;
            if (head != null) {
                while (current.next != null) {
                    start--;
                    current = current.next;
                    if (start == 0) break;
                }
                while (current.next != null) {
                    System.out.print(current.value + " ");
                    current = current.next;
                }
                System.out.print(current.value + " ");
                System.out.println();
            }
        }
        public boolean isEmpty() {
            return head == null;
        }
    }
}

