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

        // constructor with data as well as next
        Node(String data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    // add node - first, last and between
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
        Node newNode = new Node(data); // creating a new node

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

    public void addAfter(String data, int nodeNumber) {
        // creating a new node
        Node newNode = new Node(data);

        // temporary pointer variables of node type
        Node next = head;
        Node prev = null;
        int count = 0;

        while (count != nodeNumber) {
            count++;
            prev = next;
            next = next.next;
        }
        prev.next = newNode;
        newNode.next = next;
    }

    // reading/ traversing/ printing linkedlist
    public void printLinkedList() {
        Node tempNode = head;
        while (tempNode != null) {
            System.out.print(tempNode.data + " ---> ");
            tempNode = tempNode.next;
        }

        System.out.print("NULL");
        System.out.println();
    }

    // deletion - first, last and between
    public void deleteFirst() {
        head = head.next;
    }

    public void deleteLast() {
        // empty linked list
        if (head == null) {
            return;
        }

        // linked list with single node case
        if (head.next == null) {
            head = null;
        }

        // linlked list with more than one node case
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;

    }

    public void deleteAfter(int nodeNumber) {
        // empty linked list case
        if (head == null) {
            return;
        }

        // single node linked list case
        if (head.next == null) {
            head = null;
        }

        // more than one node linked list case
        Node prev = null;
        Node current = head;
        int count = 0;

        // going to the deletion node
        while (count != nodeNumber) {
            count++;
            prev = current;
            current = current.next;
        }
        prev.next = current.next;
        current.next = null;
    }

    // updation of element
    public void updateElement(int nodeNumber, String data) {
        // empty linked list case
        if (head == null) {
            return;
        }

        Node temp = head;
        int counter = 1;

        while (counter != nodeNumber) {
            counter++;
            temp = temp.next;
        }
        temp.data = data;
    }

    // searching element
    public void searchElement(String data) {
        // empty linked list case
        if (head == null) {
            return;
        }

        // searching node through data
        Node temp = head;
        int counter = 1;
        if (temp.data == data) {
            System.out.println("Node with data: " + temp.data + " Found at position : " + counter);
            return;
        }
        while (temp.next != null) {
            counter++;
            temp = temp.next;
            if (temp.data == data) {
                System.out.println("Node with data: " + temp.data + " Found at position : " + counter);
                return;
            }
        }
        System.out.println("Node with data: " + data + " Not Found on Linked List ");

    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        // adding elements at first
        list.addFirst("G");
        list.addFirst("F");
        list.addFirst("E");
        list.addFirst("D");
        list.addFirst("C");
        list.addFirst("B");
        list.addFirst("A");
        list.printLinkedList(); // print

        // list.addAfter("NewNode", 5);
        // list.printLinkedList(); // print

        // adding elements at last
        // list.addLast("E");
        // list.addLast("F");
        // list.addLast("G");
        // list.addLast("H");
        // list.printLinkedList(); // print

        // deleting elements from fist
        // list.deleteFirst();
        // list.printLinkedList(); // print
        // list.deleteLast();
        // list.printLinkedList(); // print
        // list.deleteAfter(4);
        // list.printLinkedList();

        // updating element
        // list.updateElement(3, "Updated");
        // list.printLinkedList(); // print

        // searching element
        list.searchElement("C");
    }
}