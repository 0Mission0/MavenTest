package idv.mission.example.MavenTest.Tree;

public class GenericTreeTest {
    public static void main(String[] args) {
        Node<Integer> node1 = new Node<Integer>(1);
        Node<Integer> node2 = new Node<Integer>(2);
        Node<Integer> node3 = new Node<Integer>(3);
        node1.next = node2;
        node2.next = node3;
        print(node1);
    }

    public static void print(Node<Integer> node) {
        if( node != null ) {
            System.out.print(node.content + " ");
            print(node.next);
        }
    }
}

class Node<T> {
    T content;
    Node<T> next;

    public Node(T content) {
        this.content = content;
    }
}