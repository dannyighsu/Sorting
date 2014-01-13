package algorithms;

/** Counting sort is effective for smaller size integers. It counts the number
 *  of objects that have a distinct key value, and sorts the array accordingly.
 *  O(n^2) worst-case, O(n + k) average. Uses O(n + k) memory.
 *  @author D. Hsu */

public class CountingSort {

    /** Sort ARRAY using Counting sort. MAX is the largest number that may be
     *  found in the array. */
    public static void sort(int[] array, int max) {
        int[] count = new int[max + 1];

        for (int i = 0; i < array.length; i++) {
            count[array[i]] += 1;
        }

        for (int i = 1; i < count.length; i++) {
            count[i] = count[i] + count[i - 1];
        }

        int[] result = new int[array.length];

        for (int i = array.length - 1; i >= 0; i--) {
            int value = array[i];
            int index = count[value] - 1;
            result[index] = value;
            count[value] = index;
        }
    }

}
