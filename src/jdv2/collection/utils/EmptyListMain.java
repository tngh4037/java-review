package jdv2.collection.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class EmptyListMain {

    public static void main(String[] args) {
        // 빈 가변 리스트 생성
        List<Integer> list1 = new ArrayList<>();

        // 빈 불변 리스트 생성
        List<Integer> list2 = Collections.emptyList(); // 자바5
        List<Integer> list3 = List.of(); // 자바9

        System.out.println("list1 = " + list1.getClass());
        System.out.println("list2 = " + list2.getClass());
        System.out.println("list3 = " + list3.getClass());


        Integer[] arr = {1, 2, 3, 4, 5};
        List<Integer> arrList = Arrays.asList(arr);
        arrList.set(1, 10);

        System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr)); // [1, 10, 3, 4, 5]
        System.out.println("arrList = " + arrList); // [1, 10, 3, 4, 5]
    }
}
