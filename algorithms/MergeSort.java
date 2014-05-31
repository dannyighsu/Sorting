package algorithms;

/** Implementation of Merge Sort. Splits an array into sections and joins
 *  them back together stably in sorted order. Takes memory O(n).
 *  O(nlgn) worst-case, O(nlgn / 2) best-case, O(nlgn) average.
 *  @author D. Hsu */

public class MergeSort {

    /** Sort ARRAY using Merge Sort. */
    public static void sort(int[] array) {
        int[] helper = new int[array.length];
        split(array, 0, array.length - 1, helper);
    }

    /** Split ARRAY into halves recursively. */
    public static void split(int[] array, int start, int end, int[] helper) {
        if (end <= start) {
            return;
        }
        int mid = start + (end - start) / 2;
        split(array, start, mid, helper);
        split(array, mid + 1, end, helper);
        merge(array, start, mid, end, helper);
    }

    /** Merge the halves of ARRAY. */
    public static void merge(int[] array, int start, int mid, int end,
    int[] helper) {
        for (int i = start; i <= end; i++) {
            helper[i] = array[i];
        }

        int i = start; int j = mid + 1; int k = start;

        while (i <= mid && j <= end) {
            if (helper[i] <= helper[j]) {
                array[k] = helper[i];
                i++;
            } else {
                array[k] = helper[j];
                j++;
            }
            k++;
        }

        while (i <= mid) {
            array[k] = helper[i];
            k++; i++;
        }
        while (j <= end) {
            array[k] = helper[j];
            k++; j++;
        }
    }
}
