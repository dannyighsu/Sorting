package algorithms;

/** Comb sort is an improved version of bubble sort. Generally ineffective
 *  on larger arrays. This implementation uses a shrink factor of 1.3.
 *  The shrink factor is the ratio of gap sizes between each successive
 *  iteration.
 *  O(n^2) worst-case, O(n) best-case, O(n^2) average.
 *  @author D. Hsu */

public class CombSort {

    /** Sort ARRAY using comb sort. */
    public static void sort(int[] array) {
        int gap = array.length;
        float shrink = (float) 1.3;
        boolean swapped = true;

        while (swapped) {
            gap = (int) Math.floor(gap / shrink);
            if (gap < 1) {
                gap = 1;
            }
            int i = 0;
            swapped = false;

            while (i + gap < array.length) {
                if (array[i] > array[i + gap]) {
                    swap(array, i, i + gap);
                    swapped = true;
                }
                i += 1;
            }
        }
    }

    /** Swap items I and J of ARRAY. */
    public static void swap(int[] array, int i, int j) {
        int temp = array[i]; array[i] = array[j]; array[j] = temp;
    }

}
