package sort.mergesort;

import java.util.Arrays;

public class MergeSortArray<T> {

    private void merge(Comparable<T>[] list, int lo, int mid, int hi) {
        Comparable<T>[] newList = new Comparable[list.length];
        System.arraycopy(list, lo, newList, lo, hi - lo + 1);

        int j = lo;
        int k = mid;
        for (int i = lo; i <= hi; i++) {
            if (j == mid)
                list[i] = newList[k++];
            else if (k > hi)
                list[i] = newList[j++];
            else if (newList[j].compareTo((T) newList[k]) < 1)
                list[i] = newList[j++];
            else
                list[i] = newList[k++];
        }
    }

    public void sort(Comparable<T>[] list) {
        sort(list, 0, list.length - 1);
    }

    private void sort(Comparable<T>[] list, int lo, int hi) {
        if (lo >= hi)
            return;

        int mid = lo + (hi - lo) / 2;
        sort(list, lo, mid);
        sort(list, mid + 1, hi);
        merge(list, lo, mid + 1, hi);
        System.out.println(lo + " " + mid + " " + hi);
        System.out.println(Arrays.toString(list));
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // Integer[] intArray = new Integer[] { 2, 3, 5, 7, 2, 4, 6, 8, 1, 0 };
        // new MergeSortArray().merge(intArray, 1, 4, 8);
        // System.out.println(intArray);

        Integer[] intArray1 = new Integer[] { 2, 3, 5, 7, 2, 4, 6, 8, 1, 0 };
        new MergeSortArray<Integer>().sort(intArray1);
        System.out.println(Arrays.toString(intArray1));
    }

}
