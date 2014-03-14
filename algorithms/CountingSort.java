package algorithms;

/** Counting sort is effective for smaller size integers. It counts the number
 *  of objects that have a distinct key value, and sorts the array accordingly.
 *  O(n^2) worst-case, O(n + k) average. Uses O(n + k) memory.
 *  @author D. Hsu */

public class CountingSort {

    /** Sort ARRAY using Counting sort. MAX is the largest number that may be
     *  found in the array. */
    public static void sort(int[] array, int max) {
        int[] count = new int[max + 1]; int i;

        for (i = 0; i < array.length; i++) {
            count[array[i]] += 1;
        }

        for (i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        int[] result = new int[array.length];

        for (i = 0; i < array.length; i++) {
            int value = array[i];
            int index = count[value] - 1;
            result[index] = value;
            count[value] -= 1;
        }

        for (i = 0; i < array.length; i++) {
            array[i] = result[i];
        }
    }

}
