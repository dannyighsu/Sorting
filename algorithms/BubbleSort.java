package algorithms;

/** Implementation of in-place bubble sort. Repeatedly iterates through an array,
 *  comparing adjacent items and swapping them if they're in the wrong
 *  order. Inefficient for large lists. Insertion sort tends to work better.
 *  O(N^2) worst-case, O(n) best-case, O(n^2) average.
 *  @author D. Hsu */

public class BubbleSort {

    /** Sorts ARRAY using bubble sort. */
    public static void sort(int[] array) {
        int len = array.length;
        boolean swapped = true;

        while (swapped) {
            swapped = false;

            for (int i = 1; i < len; i++) {
                if (array[i - 1] > array[i]) {
                    int temp = array[i - 1];
                    array[i - 1] = array[i];
                    array[i] = temp;
                    swapped = true;
                }
            }

            len -= 1;
        }
    }
}