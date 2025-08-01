public class SinglyLinkedList {
    // head
    Node head;

    // node class
    class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    // add node - first and last
    public void addFirst(String data) {
        Node newNode = new Node(data);

        // null linked list check
        if (head == null) {
            head = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    public void addLast(String data) {
        Node newNode = new Node(data);

        // check for null linkedlist
        if (head == null) {
            head = newNode;
            return;
        }

        Node tempNode = head;
        while (tempNode.next != null) {
            tempNode = tempNode.next;
        }
        tempNode.next = newNode;
    }

    // print linkedlist
    public void printLinkedList() {
        Node tempNode = head;
        while (tempNode != null) {
            System.out.print(tempNode.data + " ---> ");
            tempNode = tempNode.next;
        }

        System.out.print("NULL");
        System.out.println();
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        // adding elements at first
        list.addFirst("A");
        list.addFirst("B");
        list.addFirst("C");
        list.addFirst("D");
        list.printLinkedList(); // print

        // adding elements at last
        list.addLast("E");
        list.addLast("F");
        list.addLast("G");
        list.addLast("H");
        list.printLinkedList(); // print

        // deleting elements from fist
        list.printLinkedList(); // print

        // deleting elements from last
        list.printLinkedList(); // print
    }
}