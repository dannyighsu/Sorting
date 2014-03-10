package algorithms;

/** Simple integer insertion sort. Sort is in-place and stable.
 *  Effective for small data sets and nearly sorted data sets.
 *  O(N^2) worst-case, O(n) best case, O(N^2) average.
 *  @author D. Hsu */
public class InsertionSort {

    /** Sort ARRAY using a straight insertion sort. */
    public static void sort(int[] array) {
        // Iterate through ARRAY, inserting array[i] into the sorted elements.
        for (int i = 1; i < array.length; i++) {
            int k = i;
            while (k > 0 && array[k] < array[k - 1]) {
                swap(array, k, k - 1);
                k -= 1;
            }
        }
    }

    /** Swap elements. */
    private static void swap(int[] array, int i, int k) {
        array[i] = array[i] ^ array[k];
        array[k] = array[i] ^ array[k];
        array[i] = array[i] ^ array[k];
    }
}
