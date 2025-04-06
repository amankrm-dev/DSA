// Public class with queue operations
public class DynamicQueue {
    // Node class
     static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node front, rear;

    public DynamicQueue() {
        front = rear = null;
    }

    // Enqueue operation
    public void enqueue(int value) {
        Node newNode = new Node(value);
        if (rear == null) {
            front = rear = newNode;
            System.out.println("Inserted: " + value);
            return;
        }
        rear.next = newNode;
        rear = newNode;
        System.out.println("Inserted: " + value);
    }

    // Dequeue operation
    public void dequeue() {
        if (front == null) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return;
        }
        System.out.println("Removed: " + front.data);
        front = front.next;

        if (front == null) {
            rear = null;
        }
    }

    // Display operation
    public void display() {
        if (front == null) {
            System.out.println("Queue is empty.");
            return;
        }
        Node temp = front;
        System.out.print("Queue: ");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Main method to test the queue
    public static void main(String[] args) {
        DynamicQueue queue = new DynamicQueue();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.display();

        queue.dequeue();
        queue.display();

        queue.dequeue();
        queue.dequeue();
        queue.dequeue(); // Should print "Queue is empty"
    }
}
