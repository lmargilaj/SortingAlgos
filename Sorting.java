import java.util.ArrayList;
import java.util.Arrays;

public class Sorting {
    public static void main(String[] args) {
        // ArrayList of integers
        ArrayList<Integer> numList = new ArrayList<>(Arrays.asList(4, 7, 9, 2, 8));

        // ArrayList that will be used for both sorting algos
        ArrayList<Integer> bubbleSortList = new ArrayList<>(numList);
        ArrayList<Integer> mergeSortList = new ArrayList<>(numList);

        // Performs Bubble Sort
        bubbleSort(bubbleSortList);

        // Performs Merge Sort
        mergeSort(mergeSortList);

        System.out.println("Unsorted List: " + numList);
        System.out.println("Merge Sorted List: " + mergeSortList);
        System.out.println("Bubble Sorted List: " + bubbleSortList);
    }

    public static void mergeSort(ArrayList<Integer> arrayList) {
        if (arrayList.size() <= 1) {
            return;
        }

        // Split the ArrayList into two halves
        int mid = arrayList.size() / 2;
        ArrayList<Integer> left = new ArrayList<>(arrayList.subList(0, mid));
        ArrayList<Integer> right = new ArrayList<>(arrayList.subList(mid, arrayList.size()));

        // Recursively sort the two halves
        mergeSort(left);
        mergeSort(right);

        // Merge the sorted halves
        merge(arrayList, left, right);
    }

    private static void merge(ArrayList<Integer> result, ArrayList<Integer> left, ArrayList<Integer> right) {
        int i = 0, j = 0, k = 0;

        while (i < left.size() && j < right.size()) {
            if (left.get(i) < right.get(j)) {
                result.set(k++, left.get(i++));
            } else {
                result.set(k++, right.get(j++));
            }
        }

        while (i < left.size()) {
            result.set(k++, left.get(i++));
        }

        while (j < right.size()) {
            result.set(k++, right.get(j++));

        }
    }

    public static void bubbleSort(ArrayList<Integer> arrayList) {
        int n = arrayList.size();
        boolean swapped;
        do {
            swapped = false;
            for (int i = 1; i < n; i++) {
                if (arrayList.get(i - 1) > arrayList.get(i)) {
                    // Swap the elements
                    int temp = arrayList.get(i - 1);
                    arrayList.set(i - 1, arrayList.get(i));
                    arrayList.set(i, temp);
                    swapped = true;
                }
            }
            n--;
        } while (swapped);
    }

}
