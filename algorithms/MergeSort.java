package algorithms;

/** Implementation of Merge Sort. Splits an array into sections and joins
 *  them back together stably in sorted order. Takes memory O(n).
 *  O(nlgn) worst-case, O(nlgn / 2) best-case, O(nlgn) average.
 *  @author D. Hsu */

public class MergeSort {

    /** Sort ARRAY using Merge Sort. */
    public static void sort(int[] array) {
        int[] result = new int[array.length];
        split(array, 0, array.length, result);
    }

    /** Split ARRAY into halves recursively. */
    public static void split(int[] array, int start, int end, int[] result) {
        if (end - start < 2) {
            return;
        }
        int mid = end - start / 2;
        split(array, start, mid, result);
        split(array, mid, end, result);
        merge(array, start, mid, end, result);
        System.arraycopy(result, start, array, start, end - start);
    }

    /** Merge the halves of ARRAY. */
    public static void merge(int[] array, int start, int mid, int end, int[] result) {
        int i = start; int k = mid;

        for (int j = start; j < end; j++) {
            if (i < mid && (k >= end || array[i] <= array[k])) {
                result[j] = array[i++];
            } else {
                result[j] = array[k++];
            }
        }
    }
}