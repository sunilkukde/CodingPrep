package sort.quicksort;

import java.util.Arrays;

public class QuickSortArray {

    public void sort(Comparable[] array) {
        sort(array, 0, array.length - 1);
    }

    private void sort(Comparable[] array, int lo, int hi) {
        System.out.println("lo-hi=" + lo + "-" + hi);
        if (hi > lo) {
            int i = partition(array, lo, hi);
            sort(array, lo, i - 1);
            sort(array, i + 1, hi);
        }
    }

    private void exch(Comparable[] array, int i, int j) {
        System.out.print(" Exch " + array[i] + "<->" + array[j]);
        Comparable temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private int partition(Comparable[] array, int lo, int hi) {
        System.out.print(Arrays.toString(array) + "  lo-hi=" + lo + "-" + hi + "  chosen=" + array[lo]);
        int forwardIndex = lo;
        int backIndex = hi + 1;

        while (true) {
            while (array[++forwardIndex].compareTo(array[lo]) < 0) {
                if (forwardIndex == hi)
                    break;
            }
            while (array[--backIndex].compareTo(array[lo]) > 0) {
                if (backIndex == lo)
                    break;
            }

            if(forwardIndex >= backIndex) break;
            
            exch(array, forwardIndex, backIndex);
        }

        exch(array, lo, backIndex);

        System.out.println(" " + Arrays.toString(array) + " backIndex=" + backIndex);
        return backIndex;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Integer[] intArray1 = new Integer[] { 2, 3, 5, 7, 2, 4, 6, 8, -1, 9 };
        // new QuickSortArray().sort(intArray1);
        // System.out.println(Arrays.toString(intArray1));

        Character[] charArray = new Character[] { 'K', 'R', 'A', 'T', 'E', 'L', 'E', 'P', 'U', 'I', 'M', 'Q', 'C', 'X',
                'O', 'S' };
        new QuickSortArray().sort(charArray);
        System.out.println(Arrays.toString(charArray));

    }

}
