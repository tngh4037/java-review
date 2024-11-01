package thread.collection.java;

import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArraySet;

public class SetMain {

    public static void main(String[] args) {
        CopyOnWriteArraySet<Integer> copySet = new CopyOnWriteArraySet<>();
        copySet.add(1);
        copySet.add(2);
        copySet.add(3);
        System.out.println("copySet = " + copySet);

        ConcurrentSkipListSet<Object> skipSet = new ConcurrentSkipListSet<>(); // (데이터 기준) 정렬한 순서 보장 O
        skipSet.add(3);
        skipSet.add(2);
        skipSet.add(1);
        System.out.println("skipSet = " + skipSet);
    }
}
