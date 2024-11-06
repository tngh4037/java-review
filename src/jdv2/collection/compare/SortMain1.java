package jdv2.collection.compare;

import java.util.Arrays;
import java.util.Comparator;

public class SortMain1 {

    public static void main(String[] args) {
        Integer[] array = {2, 3, 1};
        System.out.println(Arrays.toString(array));

        Arrays.sort(array);
        System.out.println(Arrays.toString(array));

        Arrays.sort(array, Comparator.reverseOrder());
        System.out.println(Arrays.toString(array));
    }
}
