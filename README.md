Sorting Algorithms
=============

Daniel C. Hsu
-------------

These are just a few implementations of the most popular sorting algorithms for
easy comparison of runtimes for given inputs.

Usage:
    java algorithms.Main [ COMPARE ] [ ALGORITHM ] [ SIZE ] [ -OPTIONS ]

where ALGORITHM may be:

    <"bubble"> - Bubble Sort
    <"comb"> - Comb Sort
    <"counting"> - Counting Sort
    <"heap"> - Heap Sort
    <"insertion"> - Insertion Sort
    <"lsdradix"> - LSD Radix Sort
    <"merge"> - Merge Sort
    <"msdradix"> - MSD Radix Sort
    <"quick"> - Quick Sort
    <"selection"> - Selection Sort
    <"shell"> - Shell Sort

where OPTIONS include:

    -r <RUNS>
        Specify the number of times the array should be sorted.

    -R
        Specify that the members of the array can take any value from 0 to Integer.MAX_VALUE.

where COMPARE indicates the "-C" comparison flag:

    Usage in comparison mode:
        java algorithms.Main -C [ ALGORITHM ] [ ALGORITHM ] [ SIZE ] [ -OPTIONS ]

Test Usage:
    java algorithms.Testing [ -t ]
