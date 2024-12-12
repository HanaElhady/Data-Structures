import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.add(10);
        tree.add(5);
        tree.add(15);
        tree.add(7);

        System.out.println("Tree contains 7: " + tree.binarySearchTree(7)); // true
        System.out.println("Tree contains 20: " + tree.binarySearchTree(20)); // false

        System.out.println("Minimum: " + tree.getMinimum());
        System.out.println("Maximum: " + tree.getMaximum());

        System.out.print("PreOrder Traversal: ");
        tree.preOrderTraversal();
        System.out.println();

        System.out.print("InOrder Traversal: ");
        tree.inOrderTraversal();
        System.out.println();

        System.out.print("PostOrder Traversal: ");
        tree.postOrderTraversal();
        System.out.println();

        tree.delete(5);
        System.out.println("Tree contains 5 after deletion: " + tree.binarySearchTree(5)); // false
        BinaryTree<String> treeString = new BinaryTree<>();
        treeString.add("D");
        treeString.add("B");
        treeString.add("A");
        treeString.add("C");
        treeString.add("F");
        treeString.add("E");
        treeString.add("G");
        treeString.inOrderTraversal();
        System.out.println();
        treeString.preOrderTraversal();
        System.out.println();
        treeString.postOrderTraversal();
        System.out.println();
        treeString.breadthFirstTraversal();

    }
}

class Node<E extends Comparable<E>> {
    Node<E> left;
    Node<E> right;
    E value;

    Node(E value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

class BinaryTree<E extends Comparable<E>> {
    Node<E> root;

    private Node<E> addRecursive(Node<E> current, E value) {
        if (current == null) {
            return new Node<>(value);
        }

        if (value.compareTo(current.value) < 0) {
            current.left = addRecursive(current.left, value);
        } else if (value.compareTo(current.value) > 0) {
            current.right = addRecursive(current.right, value);
        }
        return current;
    }

    public void add(E value) {
        root = addRecursive(root, value);
    }

    private boolean contains(Node<E> current, E value) {
        if (current == null) {
            return false;
        }

        if (value.compareTo(current.value) == 0) {
            return true;
        }

        return value.compareTo(current.value) < 0
                ? contains(current.left, value)
                : contains(current.right, value);
    }

    public boolean binarySearchTree(E value) {
        return contains(root, value);
    }

    private Node<E> deleteRecursive(Node<E> current, E value) {
        if (current == null) {
            return null;
        }

        if (value.compareTo(current.value) == 0) {
            if (current.left == null && current.right == null) {
                return null;
            }

            if (current.right == null) {
                return current.left;
            }

            if (current.left == null) {
                return current.right;
            }

            E smallestValue = findSmallestValue(current.right);
            current.value = smallestValue;
            current.right = deleteRecursive(current.right, smallestValue);
            return current;
        }

        if (value.compareTo(current.value) < 0) {
            current.left = deleteRecursive(current.left, value);
        } else {
            current.right = deleteRecursive(current.right, value);
        }

        return current;
    }

    private E findSmallestValue(Node<E> root) {
        return root.left == null ? root.value : findSmallestValue(root.left);
    }

    public void delete(E value) {
        root = deleteRecursive(root, value);
    }

    private E findMinimum(Node<E> current) {
        return current.left == null ? current.value : findMinimum(current.left);
    }

    public E getMinimum() {
        if (root == null) {
            throw new NoSuchElementException("Tree is empty");
        }
        return findMinimum(root);
    }

    private E findMaximum(Node<E> current) {
        return current.right == null ? current.value : findMaximum(current.right);
    }

    public E getMaximum() {
        if (root == null) {
            throw new NoSuchElementException("Tree is empty");
        }
        return findMaximum(root);
    }

    public void preOrderTraversal() {
        preOrder(root);
    }

    public void inOrderTraversal() {
        inOrder(root);
    }

    public void postOrderTraversal() {
        postOrder(root);
    }

    private void preOrder(Node<E> current) {
        if (current == null) {
            return;
        }
        System.out.print(current.value + " ");
        preOrder(current.left);
        preOrder(current.right);
    }

    private void inOrder(Node<E> current) {
        if (current == null) {
            return;
        }
        inOrder(current.left);
        System.out.print(current.value + " ");
        inOrder(current.right);
    }

    private void postOrder(Node<E> current) {
        if (current == null) {
            return;
        }
        postOrder(current.left);
        postOrder(current.right);
        System.out.print(current.value + " ");
    }
    public void breadthFirstTraversal() {
            if (root == null) {
                return;
            }

            Queue<Node> nodes = new LinkedList<>();
            nodes.add(root);

            while (!nodes.isEmpty()) {

                Node current = nodes.remove();

                System.out.print(" " + current.value);

                if (current.left != null) {
                    nodes.add(current.left);
                }

                if (current.right != null) {
                    nodes.add(current.right);
                }
            }

    }
}
