package algorithms;

import java.util.Random;

/** Unit tests for the sorting algorithms package.
 *  @author D. Hsu */

 public class Testing {

    /** Run all tests. */
    public static void main(String[] input) {
        boolean t = false;
        if (input.length == 1 && input[0].equals("-t")) {
            t = true;
        }

        int[] array;

        array = createPermutation(1000);
        BubbleSort.sort(array);
        check(array, "Bubble", t);

        array = createPermutation(1000);
        CombSort.sort(array);
        check(array, "Comb", t);

        array = createPermutation(1000);
        CountingSort.sort(array, 1000);
        check(array, "Counting", t);

        array = createPermutation(1000);
        HeapSort.sort(array);
        check(array, "Heap", t);

        array = createPermutation(1000);
        InsertionSort.sort(array);
        check(array, "Insertion", t);

        array = createPermutation(1000);
        LSDRadixSort.sort(array);
        check(array, "LSDRadix", t);

        array = createPermutation(1000);
        MSDRadixSort.sort(array);
        check(array, "MSDRadix", t);

        array = createPermutation(1000);
        MergeSort.sort(array);
        check(array, "Merge", t);

        array = createPermutation(1000);
        QuickSort.sort(array, 0, array.length - 1);
        check(array, "Quick", t);

        array = createPermutation(1000);
        SelectionSort.sort(array);
        check(array, "Selection", t);

        array = createPermutation(1000);
        ShellSort.sort(array);
        check(array, "Shell", t);
    }

    /** Returns an array containing a pseudo-random permutation of 0 .. N-1.
     *  Shuffles the array using the Fisher-Yates algorithm. */
    private static int[] createPermutation(int N) {
        Random gen = new Random();
        int[] result = new int[N];

        for (int i = 0; i < N; i += 1) {
            result[i] = i;
        }

        for (int k = N - 1; k > 0; k -= 1) {
            int temp = result[k];
            int randInt = gen.nextInt(k + 1);
            result[k] = result[randInt];
            result[randInt] = temp;
        }

        return result;
    }

    /** Checks that ARRAY is correctly sorted. If not, returns an error
     *  referencing SORT. */
    private static void check(int[] array, String sort, boolean t) {
        for (int i = 0; i < array.length - 1; i += 1) {
            if (array[i] > array[i + 1]) {
                System.out.println("Error in " + sort + "sort");
                if (t) {
                    System.out.printf("{%d", array[0]);
                    for (int k = 1; k < array.length; k += 1) {
                        System.out.printf(", %d", array[k]);
                    }
                    System.out.println("}");
                }
                System.exit(1);
            }
        }
    }
}
