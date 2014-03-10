package algorithms;

import java.util.ArrayDeque;
import java.util.ArrayList;

/** LSD Radix Sort. Stable, in-place. Sorts starting with the
 *  least significant digit, putting each digit into buckets progessively.
 *  O(nlgn) worst-case, O(n) best-case, O(nlgn) average.
 *  @author D. Hsu */

public class LSDRadixSort {

    /** Sort ARRAY using LSD Radix Sort. */
    public static void sort(int[] array) {
        int digits = maxDigit(array);
        for (int i = 1; i <= digits; i++) {
            sortDigit(array, i);
        }
    }

    /** Returns the maximum number of digits in any one integer in ARRAY. */
    private static int maxDigit(int[] array) {
        int max = 1;
        for (int i : array) {
            String number = Integer.toString(i);
            if (number.length() > max) {
                max = number.length();
            }
        }
        return max;
    }

    /** Sort ARRAY by digit N. */
    private static void sortDigit(int[] array, int n) {
        int digit = array.length - n;
        ArrayList<ArrayDeque<Integer>> bins = new ArrayList<ArrayDeque<Integer>>();
        for (int i = 0; i <= 9; i++) {
            bins.add(new ArrayDeque<Integer>());
        }
        for (int i : array) {
            for (int k = 1; k < n; k++) {
                i /= 10;
            }
            int num = i % 10;

            for (int k = 0; k <= 9; k++) {
                if (num == k) {
                    bins.get(k).add(i);
                    break;
                }
            }
            int index = 0;

            for (ArrayDeque<Integer> bin : bins) {
                while (!bin.isEmpty()) {
                    array[index] = bin.remove();
                    index += 1;
                }
            }
        }
    }

}
