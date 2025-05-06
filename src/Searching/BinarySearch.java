package Searching;

public class BinarySearch {

    // Iterative binary search
    public static int binarySearch(int[] arr, int key) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == key) {
                return mid; // Key found
            }

            if (arr[mid] < key) {
                left = mid + 1; // Search in the right half
            } else {
                right = mid - 1; // Search in the left half
            }
        }

        return -1; // Key not found
    }

    public static void main(String[] args) {
        int[] sortedArray = {2, 4, 6, 8, 10, 12, 14};
        int key = 10;

        int result = binarySearch(sortedArray, key);
        if (result != -1) {
            System.out.println("Element found at index: " + result);
        } else {
            System.out.println("Element not found in the array.");
        }
    }
}