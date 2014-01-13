package algorithms;

/** Implementation of Heapsort. Heapsort is in-place but unstable.
 *  It builds a heap out of the given array, then creates a sorted
 *  array by removing the largest element from the heap and then
 *  reconstructing.
 *  O(nlgn) worst-case, O(nlgn) best-case, O(nlgn) average.
 *  @author D. Hsu */

public class HeapSort {

    /** Sort ARRAY using Heapsort. */
    public static void sort(int[] array) {
        heapify(array);
        int end = array.length - 1;

        while (end > 0) {
            int temp = array[end];
            array[end] = array[0];
            array[0] = temp;
            end -= 1;
            shift(array, 0, end);
        }
    }

    /** Construct a heap out of ARRAY. */
    private static void heapify(int[] array) {
        int start = (array.length - 2) / 2;

        while (start >= 0) {
            shift(array, start, array.length - 1);
            start -= 1;
        }
    }

    /** Reheapify the ARRAY. */
    private static void shift(int[] array, int start, int end) {
        int root = start;

        while (root * 2 + 1 <= end) {
            int child = root * 2 + 1;
            int swap = child;
            if (array[swap] < array[child]) {
                swap = child;
            }
            if (child + 1 <= end && array[swap] < array[child + 1]) {
                swap = child + 1;
            }
            if (swap != root) {
                int temp = array[root]; array[root] = array[swap]; array[swap] = temp;
                root = swap;
            } else {
                return;
            }
        }
    }
}