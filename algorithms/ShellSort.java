package algorithms;

import java.util.List;
import java.util.Arrays;

/** Simple in-place shell sort. Shell sort involves insertion
 *  sorting the given array multiple times in decreasing gaps.
 *  This implementation uses Marcin Ciura's gap sequence.
 *  O(n^2) worst-case, O(n) best-case, O(N^5/3) average.
 *  @author D. Hsu */

public class ShellSort {

    /** Perform a shell sort on ARRAY. */
    public static void sort(int[] array) {

        // Ciura's gap sequence.
        List<Integer> gaps = Arrays.asList(701, 301, 132, 57, 23, 10, 4, 1);

        for (int i = 0; i < gaps.size(); i++) {
            if (array.length < gaps.get(i)) {
                gaps.remove(i);
            }
        }

        for (int gap : gaps) {
            for (int i = gap; i < array.length; i++) {
                int temp = array[i];
                int j = i;
                for (; j >= gap && array[j - gap] > temp; j -= gap) {
                    array[j] = array[j - gap];
                }
                array[j] = temp;
            }
        }
    }
}