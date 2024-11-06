package jdv2.collection.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ImmutableMain {

    public static void main(String[] args) {
        // 불변 리스트 생성
        List<Integer> list = List.of(1, 2, 3);
        System.out.println("list = " + list);

        // 불변 -> 가변
        ArrayList<Integer> mutableList = new ArrayList<>(list); // list 값을 가지고, 값을 읽어서 ArrayList 로 다시 생성
        mutableList.set(1, 10);
        mutableList.add(4);
        System.out.println("mutableList = " + mutableList);
        System.out.println("mutableList.getClass() = " + mutableList.getClass());

        // 가변 -> 불변
        List<Integer> unmodifiableList = Collections.unmodifiableList(mutableList);
        System.out.println("unmodifiableList = " + unmodifiableList);
        System.out.println("unmodifiableList.getClass() = " + unmodifiableList.getClass());
    }
}
