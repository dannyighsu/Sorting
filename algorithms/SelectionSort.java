package algorithms;

/** Selection sort is an in-place comparison sort. It is generally inefficient
 *  on larger arrays, and Insertion sort usually performs better. It works by repeatedly
 *  finding the smallest element in the array and swapping it with the element
 *  at the end of the sorted items.
 *  O(n^2) worst-case, O(n) best-case, O(n^2) average.
 *  @author D. Hsu */

public class SelectionSort {

    /** Sort ARRAY using Insertion sort. */
    public static void sort(int[] array) {
        int i; int j;
        for (j = 0; j < array.length - 1; j++) {
            int min = j;
            for (i = j + 1; i < array.length; i++) {
                if (array[i] < array[min]) {
                    min = i;
                }
            }
            if (min != j) {
                int temp = array[j]; array[j] = array[min]; array[min] = temp;
            }
        }
    }

}
