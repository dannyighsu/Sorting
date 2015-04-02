package algorithms;

import java.util.Scanner;
import java.util.Random;
import java.io.File;
import java.io.IOException;

/** FUNCTIONALITY TO ADD:
 *  Specify parameters of sort (e.g. quicksort pivots),
 *  Specify whether random, nearly sorted, reverse order.
 *  Specify range of integers to be sorted.
 *  Specify negative numbers. */

/** Program to run sorting algorithms, timed.
 *  @author D. Hsu */
public class Main {

    /** Runs the given sorting algorithm.
    *   Prints out the elapsed time in milliseconds. */
    public static void main(String[] args) {
        if (args.length > 6 || args.length < 1) {
            usage();
        }

        if (args[0].equals("-C")) {
            comp(args);
        }

        String algorithm = null;
        int size = 0;
        int runs = 1;
        boolean randomInts = false;

        try {
            algorithm = args[0];
            size = Integer.parseInt(args[1]);

            for (int i = 2; i < args.length; i++) {
                if (args[i].equals("-r")) {
                    runs = Integer.parseInt(args[i + 1]);
                    i += 1;
                } else if (args[i].equals("-R")) {
                    randomInts = true;
                } else {
                    usage();
                }
            }
        } catch (IllegalArgumentException | IndexOutOfBoundsException e) {
            usage();
        }
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < runs; i++) {
            int[] array = new int[size];
            if (!randomInts) {
                array = createPermutation(size);
            } else {
                array = createRandomPermutation(size);
            }
            parseInput(algorithm, array, randomInts);

            for (int k = 0; k < array.length - 1; k++) {
                if (array[k] > array[k + 1]) {
                    System.err.println("Error in sorting algorithm.");
                    break;
                }
            }
        }

        long elapsed = System.currentTimeMillis() - startTime;
        System.out.printf("%d run(s) of %s took %d milliseconds, at an average of"
                + " %s milliseconds per run.\n",
                runs, algorithm, elapsed, elapsed / runs);
    }

    /** Run in comparison mode. */
    private static void comp(String[] args) {
        if (args.length > 7) {
            usage();
        }

        String algorithm1 = null;
        String algorithm2 = null;
        int size = 0;
        int runs = 1;
        boolean randomInts = false;

        try {
            algorithm1 = args[1];
            algorithm2 = args[2];

            size = Integer.parseInt(args[3]);

            for (int i = 4; i < args.length; i++) {
                if (args[i].equals("-r")) {
                    runs = Integer.parseInt(args[i + 1]);
                    i += 1;
                } else if (args[i].equals("-R")) {
                    randomInts = true;
                } else {
                    usage();
                }
            }
        } catch (IllegalArgumentException | IndexOutOfBoundsException e) {
            usage();
        }

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < runs; i++) {
            int[] array = new int[size];
            if (!randomInts) {
                array = createPermutation(size);
            } else {
                array = createRandomPermutation(size);
            }
            parseInput(algorithm1, array, randomInts);

            if (i == 0) {
                for (int k = 0; k < size - 1; k++) {
                    if (array[k] > array[k + 1]) {
                        System.err.println("Error in sorting algorithm.");
                        break;
                    }
                }
            }
        }

        long elapsed1 = System.currentTimeMillis() - startTime;
        System.out.printf("%d run(s) of %s took %d milliseconds, at an average"
            + " of %s milliseconds per run.\n",
                runs, algorithm1, elapsed1, elapsed1 / runs);

        startTime = System.currentTimeMillis();
        for (int i = 0; i < runs; i++) {
            int[] array = new int[size];
            if (!randomInts) {
                array = createPermutation(size);
            } else {
                array = createRandomPermutation(size);
            }
            parseInput(algorithm2, array, randomInts);

            if (i == 0) {
                for (int k = 0; k < size - 1; k++) {
                    if (array[k] > array[k + 1]) {
                        System.err.println("Error in sorting algorithm.");
                        break;
                    }
                }
            }
        }

        long elapsed2 = System.currentTimeMillis() - startTime;
        System.out.printf("%d run(s) of %s took %d milliseconds, at an average"
            + " of %s milliseconds per run.\n",
                runs, algorithm2, elapsed2, elapsed2 / runs);
        if (elapsed2 > elapsed1) {
            String temp = algorithm2;
            algorithm2 = algorithm1;
            algorithm1 = temp;
            long temp1 = elapsed1;
            elapsed1 = elapsed2;
            elapsed2 = temp1;
        }
        System.out.printf("%s took %d milliseconds longer than %s at a size "
            + "of %d with %d runs.\n", algorithm1, elapsed1 - elapsed2,
                algorithm2, size, runs);
        System.exit(0);
    }

    /** Parses the given input ARRAY and runs the sorting algorithm designated by
     *  SORT on it. If RANDOM is true, the integers in the array may take any value
     *  from 0 to Integer.MAX_VALUE. */
    private static void parseInput(String sort, int[] array, boolean random) {
        switch(sort) {
        case "bubble":
            BubbleSort.sort(array);
            break;
        case "comb":
            CombSort.sort(array);
            break;
        case "counting":
            if (random) {
                CountingSort.sort(array, Integer.MAX_VALUE - 1);
            }
            else {
                CountingSort.sort(array, array.length - 1);
            }
            break;
        case "heap":
            HeapSort.sort(array);
            break;
        case "insertion":
            InsertionSort.sort(array);
            break;
        case "lsdradix":
            LSDRadixSort.sort(array);
            break;
        case "merge":
            MergeSort.sort(array);
            break;
        case "msdradix":
            MSDRadixSort.sort(array);
            break;
        case "quick":
            QuickSort.sort(array, 0, array.length - 1);
            break;
        case "selection":
            SelectionSort.sort(array);
            break;
        case "shell":
            ShellSort.sort(array);
            break;
        }
    }

    /** Returns an array containing a pseudo-random permutation of
     *  0 .. Integer.MAX_VALUE */
    private static int[] createRandomPermutation(int N) {
        Random rand = new Random();
        int[] result = new int[N];
        for (int i = 0; i < N; i++) {
            result[i] = rand.nextInt();
        }
        return result;
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

    /** Prints out a usage message. */
    private static void usage() {
        Scanner usage;

        try {
            usage = new Scanner(new File("Usage.txt"));
        } catch (IOException e) {
            System.out.println("No help found.");
            System.exit(1);
            return;
        }

        while (usage.hasNextLine()) {
            System.out.println(usage.nextLine());
        }

        usage.close();
        System.exit(1);
    }
}
