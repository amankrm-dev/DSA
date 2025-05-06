package Queue;

public class CircularQueue {
    int front, rear;
    int size;
    int[] queue;

    public CircularQueue(int size) {
        this.size = size;
        front = rear = -1;
        queue = new int[size];
    }

    // Enqueue operation
    public void enqueue(int value) {
        if ((rear + 1) % size == front) {
            System.out.println("Queue is full. Cannot insert " + value);
            return;
        }

        if (front == -1) front = 0;

        rear = (rear + 1) % size;
        queue[rear] = value;
        System.out.println("Inserted: " + value);
    }

    // Dequeue operation
    public void dequeue() {
        if (front == -1) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return;
        }

        System.out.println("Removed: " + queue[front]);
        if (front == rear) {
            // Only one element
            front = rear = -1;
        } else {
            front = (front + 1) % size;
        }
    }

    // Display operation
    public void display() {
        if (front == -1) {
            System.out.println("Queue is empty.");
            return;
        }

        System.out.print("Queue: ");
        int i = front;
        while (true) {
            System.out.print(queue[i] + " ");
            if (i == rear) break;
            i = (i + 1) % size;
        }
        System.out.println();
    }

    // Main method
    public static void main(String[] args) {
        CircularQueue cQueue = new CircularQueue(5); // 1 less than size is max elements

        cQueue.enqueue(10);
        cQueue.enqueue(20);
        cQueue.enqueue(30);
        cQueue.enqueue(40);
        cQueue.enqueue(50); // Queue is full
        cQueue.display();

        cQueue.dequeue();
        cQueue.dequeue();
        cQueue.display();

        cQueue.enqueue(60);
        cQueue.enqueue(70);
        cQueue.display();
    }
}
