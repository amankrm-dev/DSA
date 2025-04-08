public class PriorityQueue {
    static int[] queue = new int[5];
    static int size = 0;

    // Insert method
    static void insert(int value) {
        if (size == queue.length) {
            System.out.println("Queue is full.");
            return;
        }
        queue[size++] = value;
        System.out.println(value + " inserted.");
    }

    // Delete max method
    static void deleteMax() {
        if (size == 0) {
            System.out.println("Queue is empty.");
            return;
        }

        int max = queue[0];
        int pos = 0;
        for (int i = 1; i < size; i++) {
            if (queue[i] > max) {
                max = queue[i];
                pos = i;
            }
        }

        System.out.println("Deleted max: " + max);

        // Shift elements
        for (int i = pos; i < size - 1; i++) {
            queue[i] = queue[i + 1];
        }
        size--;
    }

    // Display method
    static void display() {
        if (size == 0) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.print("Queue: ");
        for (int i = 0; i < size; i++) {
            System.out.print(queue[i] + " ");
        }
        System.out.println();
    }

    // Main method
    public static void main(String[] args) {
        insert(20);
        insert(50);
        insert(30);
        display();

        deleteMax();
        display();
    }
}
