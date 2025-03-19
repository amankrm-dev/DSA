public class DoublyCircularLinkedList {
    private class Node {
        int data;
        Node prev, next;

        Node(int data) {
            this.data = data;
            prev = next = null;
        }
    }

    Node head, tail;

    public DoublyCircularLinkedList() {
        head = tail = null;
    }

    public void insertAtFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            head.next = head.prev = head;
        } else {
            newNode.next = head;
            newNode.prev = tail;
            head.prev = newNode;
            tail.next = newNode;
            head = newNode;
        }
    }

    public void insertAtPos(int data, int pos) {
        if (pos == 1 || head == null) {
            insertAtFirst(data);
            return;
        }
        Node cNode = head;
        for (int i = 1; i < pos - 1 && cNode.next != head; i++)
            cNode = cNode.next;
        Node newNode = new Node(data);
        newNode.next = cNode.next;
        newNode.prev = cNode;
        cNode.next.prev = newNode;
        cNode.next = newNode;
        if (cNode == tail) tail = newNode;
    }

    public void insertAtLast(int data) {
        if (head == null) {
            insertAtFirst(data);
            return;
        }
        Node newNode = new Node(data);
        newNode.prev = tail;
        newNode.next = head;
        tail.next = newNode;
        head.prev = newNode;
        tail = newNode;
    }

    public void deleteAtFirst() {
        if (head == null) return;
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = tail;
            tail.next = head;
        }
    }

    public void deleteAtPos(int pos) {
        if (head == null) return;
        if (pos == 1) {
            deleteAtFirst();
            return;
        }
        Node cNode = head;
        for (int i = 1; i < pos - 1 && cNode.next != head; i++)
            cNode = cNode.next;
        cNode.next = cNode.next.next;
        cNode.next.prev = cNode;
        if (cNode.next == head) tail = cNode;
    }

    public void deleteAtLast() {
        if (head == null) return;
        if (head == tail) {
            head = tail = null;
            return;
        }
        tail = tail.prev;
        tail.next = head;
        head.prev = tail;
    }

    public boolean search(int data) {
        if (head == null) return false;
        Node cNode = head;
        do {
            if (cNode.data == data) return true;
            cNode = cNode.next;
        } while (cNode != head);
        return false;
    }

    public void display() {
        if (head == null) return;
        Node cNode = head;
        do {
            System.out.print(cNode.data + " <-> ");
            cNode = cNode.next;
        } while (cNode != head);
        System.out.println("(Back to Head)");
    }

    public static void main(String[] args) {
        DoublyCircularLinkedList list = new DoublyCircularLinkedList();
        list.insertAtFirst(10);
        list.insertAtLast(20);
        list.insertAtPos(15, 2);
        list.display(); // Expected Output: 10 <-> 15 <-> 20 <-> (Back to Head)

        list.deleteAtFirst();
        list.deleteAtLast();
        list.display(); // Expected Output: 15 <-> (Back to Head)

        System.out.println("Search 15: " + list.search(15)); // Expected: true
        System.out.println("Search 10: " + list.search(10)); // Expected: false
    }
}
