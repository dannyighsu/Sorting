package algorithms;

import java.util.Arrays;
import java.util.Random;
import java.util.HashMap;

/** Quicksort is an unstable sort with O(lgn) memory. It
 *  sorts an array by picking a pivot, then reordering the list
 *  so that elements less than the pivot come before it while elements
 *  greater come after it. This is referred to as partitioning.
 *  This particular implementation picks pivots by the median.
 *  O(nlgn) best-case, O(n^2) worst-case, O(nlgn) average.
 *  @author D. Hsu */

public class QuickSort {

    /** Sort ARRAY using Quicksort. Initially, LEFT is the leftmost element of the
     *  array, right is the rightmost. */
    public static void sort(int[] array, int left, int right) {
        if (left < right) {
            int pivot = choosePivot(array, left, right);
            int pivotIndex = partition(array, left, right, pivot);
            sort(array, left, pivotIndex);
            sort(array, pivotIndex + 1, right);
        }
    }

    /** Partition the array, allocating elements less than the pivot to the left
     *  and elements greater to the right. */
    public static int partition(int[] array, int left, int right, int pivot) {
        int value = array[pivot];
        swap(array, pivot, right);
        int index = left;
        for (int i = left; i < right; i++) {
            if (array[i] < value) {
                swap(array, i, index);
                index += 1;
            }
        }
        swap(array, index, right);
        return index;
    }

    /** Swap elements I and J of ARRAY. */
    public static void swap(int[] array, int i, int j) {
        int temp = array[i]; array[i] = array[j]; array[j] = temp;
    }

    /** Choose a pivot for ARRAY by taking the median of 3 random elements. */
    public static int choosePivot(int[] array, int left, int right) {
        Random rand = new Random();
        HashMap<Integer, Integer> randoms = new HashMap<Integer, Integer>();
        int[] buffer = new int[3];
        for (int i = 0; i < buffer.length; i++) {
            int randInt = rand.nextInt(right - left) + left;
            randoms.put(array[randInt], randInt);
            buffer[i] = array[randInt];
        }
        Arrays.sort(buffer);
        return randoms.get(buffer[1]);
    }

}
