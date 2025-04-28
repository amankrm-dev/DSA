package Trees;
import java.util.Arrays;

public class MaxHeap {
    private int[] heap;
    private int size;
    private int capacity;

    // Constructor
    public MaxHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        heap = new int[capacity];
    }

    // Get index helpers
    private int parent(int i) { return (i - 1) / 2; }
    private int leftChild(int i) { return (2 * i) + 1; }
    private int rightChild(int i) { return (2 * i) + 2; }

    // Insert a new element
    public void insert(int key) {
        if (size == capacity) {
            System.out.println("Heap is full");
            return;
        }
        heap[size] = key;
        int current = size;
        size++;

        // Heapify Up
        while (current > 0 && heap[current] > heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    // Get max element (root)
    public int getMax() {
        if (size == 0) {
            throw new IllegalStateException("Heap is empty");
        }
        return heap[0];
    }

    // Remove and return the max element
    public int extractMax() {
        if (size == 0) {
            throw new IllegalStateException("Heap is empty");
        }
        int max = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapify(0);
        return max;
    }

    // Heapify (top-down)
    private void heapify(int i) {
        int largest = i;
        int left = leftChild(i);
        int right = rightChild(i);

        if (left < size && heap[left] > heap[largest]) {
            largest = left;
        }
        if (right < size && heap[right] > heap[largest]) {
            largest = right;
        }
        if (largest != i) {
            swap(i, largest);
            heapify(largest);
        }
    }

    // Build heap from an array
    public void buildHeap(int[] array) {
        if (array.length > capacity) {
            throw new IllegalArgumentException("Array is too large");
        }
        size = array.length;
        heap = Arrays.copyOf(array, capacity);

        // Start from last non-leaf node
        for (int i = parent(size - 1); i >= 0; i--) {
            heapify(i);
        }
    }

    // Delete element at index
    public void delete(int index) {
        if (index >= size) {
            System.out.println("Index out of range");
            return;
        }
        heap[index] = Integer.MAX_VALUE;

        // Move up to root
        while (index > 0 && heap[index] > heap[parent(index)]) {
            swap(index, parent(index));
            index = parent(index);
        }
        extractMax();
    }

    // Swap helper
    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    // Print the heap
    public void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    // Main method to test
    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap(15);
        maxHeap.insert(10);
        maxHeap.insert(20);
        maxHeap.insert(5);
        maxHeap.insert(6);
        maxHeap.insert(1);
        maxHeap.insert(8);
        maxHeap.insert(9);
        maxHeap.insert(4);

        System.out.println("Max Heap:");
        maxHeap.printHeap();

        System.out.println("Max Element: " + maxHeap.getMax());

        System.out.println("Extract Max: " + maxHeap.extractMax());
        maxHeap.printHeap();

        System.out.println("Delete index 2:");
        maxHeap.delete(2);
        maxHeap.printHeap();
    }
}
