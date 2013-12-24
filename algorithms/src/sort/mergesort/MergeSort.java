package sort.mergesort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort<T extends Comparable<T>> {

    private List<T> merge(List<T> first, List<T> sec) {
        System.out.println("Merging " + first + " and " + sec);

        int firstCntr = 0;
        int secCntr = 0;
        List<T> newList = new ArrayList<T>();

        int firstSize = first.size();
        int secSize = sec.size();
        if (firstSize == 0) {
            return sec;
        } else if (secSize == 0) {
            return first;
        }

        for (int i = 0; i < firstSize + secSize; i++) {
            if (first.get(firstCntr).compareTo(sec.get(secCntr)) < 1) {
                newList.add(first.get(firstCntr));
                firstCntr++;
                if (firstCntr == firstSize) {
                    newList.addAll(sec.subList(secCntr, secSize));
                    break;
                }
            } else {
                newList.add(sec.get(secCntr));
                secCntr++;
                if (secCntr == secSize) {
                    newList.addAll(first.subList(firstCntr, firstSize));
                    break;
                }
            }
        }

        return newList;
    }

    public List<T> sort(List<T> listToSort) {
        if (listToSort.size() <= 1) {
            return listToSort;
        }
        int mid = (listToSort.size() / 2) - 1;
        return merge(sort(listToSort.subList(0, mid + 1)), sort(listToSort.subList(mid + 1, listToSort.size())));
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        List<Integer> first = Arrays.asList(new Integer[] { 4 });
        List<Integer> sec = Arrays.asList(new Integer[] { 7 });

        // System.out.println(new MergeSort<Integer>().merge(first, sec));

        List<Integer> listToSort = Arrays.asList(new Integer[] { 5, 6, 3, 2, 4, 1, 7 });
        System.out.println(new MergeSort<Integer>().sort(listToSort));
    }

}
