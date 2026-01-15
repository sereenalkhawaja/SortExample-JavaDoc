import java.util.Arrays;

/**
 * This class demonstrates sorting algorithms:
 * Quick Sort and Merge Sort.
 *
 * @author Y
 * @version 1.0
 */
public class SortExample {

    /**
     * Main method to test sorting algorithms.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {

        // Unsorted arrays
        Integer[] array1 = {12, 13, 24, 10, 3, 6, 90, 70};
        int[] array2 = {2, 6, 3, 5, 1};

        // Sort using Quick Sort
        quickSort(array1, 0, array1.length - 1);
        System.out.println("Quick Sort Result: " + Arrays.toString(array1));

        // Sort using Merge Sort
        mergeSort(array2, array2.length);
        System.out.println("Merge Sort Result: " + Arrays.toString(array2));
    }

    /**
     * Sorts an array using Quick Sort algorithm.
     *
     * @param arr  the array to sort
     * @param low  starting index
     * @param high ending index
     */
    public static void quickSort(Integer[] arr, int low, int high) {

        if (arr == null || arr.length == 0 || low >= high) {
            return;
        }

        int middle = low + (high - low) / 2;
        int pivot = arr[middle];

        int i = low;
        int j = high;

        while (i <= j) {

            while (arr[i] < pivot) {
                i++;
            }

            while (arr[j] > pivot) {
                j--;
            }

            if (i <= j) {
                swap(arr, i, j);
                i++;
                j--;
            }
        }

        if (low < j) {
            quickSort(arr, low, j);
        }

        if (high > i) {
            quickSort(arr, i, high);
        }
    }

    /**
     * Swaps two elements in an array.
     *
     * @param array the array
     * @param x     first index
     * @param y     second index
     */
    public static void swap(Integer[] array, int x, int y) {
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }

    /**
     * Sorts an array using Merge Sort algorithm.
     *
     * @param a the array to sort
     * @param n size of the array
     */
    public static void mergeSort(int[] a, int n) {

        if (n < 2) {
            return;
        }

        int mid = n / 2;
        int[] left = new int[mid];
        int[] right = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            left[i] = a[i];
        }

        for (int i = mid; i < n; i++) {
            right[i - mid] = a[i];
        }

        mergeSort(left, mid);
        mergeSort(right, n - mid);

        merge(a, left, right, mid, n - mid);
    }

    /**
     * Merges two sub-arrays.
     *
     * @param a     original array
     * @param left  left sub-array
     * @param right right sub-array
     * @param l     left size
     * @param r     right size
     */
    public static void merge(int[] a, int[] left, int[] right, int l, int r) {

        int i = 0, j = 0, k = 0;

        while (i < l && j < r) {
            if (left[i] <= right[j]) {
                a[k++] = left[i++];
            } else {
                a[k++] = right[j++];
            }
        }

        while (i < l) {
            a[k++] = left[i++];
        }

        while (j < r) {
            a[k++] = right[j++];
        }
    }

    /**
     * Checks if the array is sorted.
     *
     * @param x the array
     * @return true if sorted, false otherwise
     */
    private static boolean isSorted(int[] x) {

        for (int i = 0; i < x.length - 1; i++) {
            if (x[i] > x[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
