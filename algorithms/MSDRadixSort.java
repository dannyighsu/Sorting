package algorithms;

import java.util.ArrayDeque;
import java.util.HashMap;

/** MSD Radix Sort. Stable, in-place. Sorts starting with the
 *  most significant digit, putting each digit into buckets progessively.
 *  O(nlgn) worst-case, O(n) best-case, O(nlgn) average.
 *  @author D. Hsu */

public class MSDRadixSort {

    /** Sort ARRAY using MSD Radix Sort. */
    public static void sort(int[] array) {
        int digits = maxDigit(array);
        for (int i = digits; i >= 1; i--) {
            sortDigit(array, i);
        }
    }

    /** Returns the maximum number of digits in any one integer in ARRAY. */
    public static int maxDigit(int[] array) {
        int max = 0;
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
        HashMap<Integer, ArrayDeque<Integer>> bins =
        new HashMap<Integer, ArrayDeque<Integer>>();

        for (int i = 0; i <= 9; i++) {
            bins.put(i, new ArrayDeque<Integer>());
        }

        for (int i : array) {
            for (int k = 1; k < n; k++) {
                i /= 10;
            }
            int num = i % 10;
            bins.get(num).add(i);
        }
        int index = 0;

        for (int k = 0; k <= 9; k++) {
            ArrayDeque<Integer> bin = bins.get(k);
            while (!bin.isEmpty()) {
                array[index] = bin.remove();
                index += 1;
            }
        }
    }

}
