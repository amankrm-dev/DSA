import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class MenuDrivenSLL {
    private Node head, tail;
    private int length;

    MenuDrivenSLL() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public void insertAtLast(int data) {
        Node newNode = new Node(data);
        if (this.length == 0) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.next = newNode;
            this.tail = newNode;
        }
        this.length++;
    }

    public void insertAtFirst(int data) {
        Node newNode = new Node(data);
        if (this.length == 0) {
            this.insertAtLast(data);
        } else {
            newNode.next = this.head;
            this.head = newNode;
        }
        this.length++;
    }

    public void deleteByValue(int data) {
        if (this.head == null) {
            System.out.println("List is empty. Nothing to delete.");
            return;
        }
        if (this.head.data == data) {
            head = head.next;
            this.length--;
            return;
        }
        Node current = head;
        Node prev = null;
        while (current != null && current.data != data) {
            prev = current;
            current = current.next;
        }
        if (current == null) {
            System.out.println("Element not found.");
            return;
        }
        prev.next = current.next;
        if (current == tail) {
            tail = prev;
        }
        this.length--;
    }

    public boolean search(int data) {
        Node current = this.head;
        while (current != null) {
            if (current.data == data) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void display() {
        if (this.head == null) {
            System.out.println("The list is empty.");
            return;
        }
        Node current = this.head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MenuDrivenSLL list = new MenuDrivenSLL();
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Insert at first");
            System.out.println("2. Insert at last");
            System.out.println("3. Delete by value");
            System.out.println("4. Search");
            System.out.println("5. Display");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter value to insert at first: ");
                    int firstValue = scanner.nextInt();
                    list.insertAtFirst(firstValue);
                    break;
                case 2:
                    System.out.print("Enter value to insert at last: ");
                    int lastValue = scanner.nextInt();
                    list.insertAtLast(lastValue);
                    break;
                case 3:
                    System.out.print("Enter value to delete: ");
                    int deleteValue = scanner.nextInt();
                    list.deleteByValue(deleteValue);
                    break;
                case 4:
                    System.out.print("Enter value to search: ");
                    int searchValue = scanner.nextInt();
                    if (list.search(searchValue)) {
                        System.out.println("Value found in the list.");
                    } else {
                        System.out.println("Value not found in the list.");
                    }
                    break;
                case 5:
                    list.display();
                    break;
                case 6:
                    System.out.println("Exiting program.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
