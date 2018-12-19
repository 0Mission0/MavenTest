package idv.mission.example.MavenTest.yahoo;

/**
 * 1.
 * 
 * P   C   N
 * □   1 → 2 → 3 → 4 → 5
 * 
 * 2.
 *     
 * P   C   N
 * □ ← 1 → 2 → 3 → 4 → 5
 * 
 * 3.
 *     P
 *     C   N
 * □ ← 1 → 2 → 3 → 4 → 5
 * 
 * 4.
 *         C
 *     P   N
 * □ ← 1 → 2 → 3 → 4 → 5
 * 
 * 5.
 *     P   C   N   
 * □ ← 1 → 2 → 3 → 4 → 5
 * 
 * 6.
 *     P   C   N   
 * □ ← 1 ← 2 → 3 → 4 → 5
 * 
 * ......
 * 
 * End.
 *                 P   C   N     
 * □ ← 1 ← 2 ← 3 ← 4 ← 5 
 * 
 */

public class ReverseLinkedList {

    public static void main(String[] args) {
        Node root = initial();
        Node prev = null;
        Node current = root;
        Node next = current.next;

        print(current);

        while (next != null) {
            current.next = prev;
            prev = current;
            current = next;
            next = next.next;
        }

        current.next = prev;

        print(current);
    }

    public static Node initial() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        return node1;
    }

    public static void print(Node node) {
        if( node != null ) {
            System.out.print(node.value + " ");
            print(node.next);
        }
        else {
            System.out.println();
        }
    }

}

class Node {
    Node next;
    int value;

    public Node(int value) {
        this.value = value;
    }

    public String toString() {
        return String.valueOf(value);
    }
}
