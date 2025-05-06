package Lists;

public class StaticList {
    int[] arr;
    int size;
    int capacity;

    public StaticList(int capacity) {
        arr = new int[capacity];
        this.capacity = capacity;
        size = 0;
    }

    public void insertAtFirst(int data) {
        if (size == capacity) {
            System.out.println("Error: List is full. Cannot insert.");
            return;
        }
        for (int i = size; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = data;
        size++;
    }

    public void insertAtPos(int data, int pos) {
        if (pos < 1 || pos > size + 1) {
            System.out.println("Error: Invalid position for insertion.");
            return;
        }
        if (size == capacity) {
            System.out.println("Error: List is full. Cannot insert.");
            return;
        }
        for (int i = size; i >= pos; i--) {
            arr[i] = arr[i - 1];
        }
        arr[pos - 1] = data;
        size++;
    }

    public void insertAtLast(int data) {
        if (size == capacity) {
            System.out.println("Error: List is full. Cannot insert.");
            return;
        }
        arr[size] = data;
        size++;
    }

    public void deleteAtFirst() {
        if (size == 0) {
            System.out.println("Error: List is empty. Cannot delete.");
            return;
        }
        for (int i = 0; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        size--;
    }

    public void deleteAtPos(int pos) {
        if (pos < 1 || pos > size) {
            System.out.println("Error: Invalid position for deletion.");
            return;
        }
        for (int i = pos - 1; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        size--;
    }

    public void deleteAtLast() {
        if (size == 0) {
            System.out.println("Error: List is empty. Cannot delete.");
            return;
        }
        size--;
    }

    public void display() {
        if (size == 0) {
            System.out.println("List is empty.");
            return;
        }
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public boolean search(int data) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == data) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        StaticList list = new StaticList(10);

        list.insertAtFirst(12);
        list.insertAtFirst(1);
        list.insertAtFirst(122);
        list.insertAtFirst(132);
        list.insertAtPos(44, 3);
        list.insertAtLast(23);
        list.insertAtPos(99, 10); // Invalid insertion
        list.insertAtPos(88, 6);  // Valid insertion

        list.display(); // Expected: 132 122 44 1 12 88 23

        list.deleteAtFirst();
        list.deleteAtPos(2);
        list.deleteAtLast();
        list.deleteAtPos(10); // Invalid deletion

        list.display(); // Expected: 122 1 12 88

        System.out.println("Search 22: " + list.search(22)); // Expected: false
        System.out.println("Search 88: " + list.search(88)); // Expected: true
    }
}
