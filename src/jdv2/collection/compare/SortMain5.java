package jdv2.collection.compare;

import java.util.TreeSet;

public class SortMain5 {

    public static void main(String[] args) {
        MyUser myUser1 = new MyUser("a", 30);
        MyUser myUser2 = new MyUser("b", 20);
        MyUser myUser3 = new MyUser("c", 10);

        TreeSet<MyUser> treeSet1 = new TreeSet<>(); // MyUser 는 Comparable 구현되어 있어야 함. (애초에 트리를 생성할 때부터 정렬)
        treeSet1.add(myUser1);
        treeSet1.add(myUser2);
        treeSet1.add(myUser3);

        System.out.println("Comparable 기본 정렬");
        System.out.println(treeSet1);

        TreeSet<MyUser> treeSet2 = new TreeSet<>(new IdComparator()); // 정렬기준을 따로 주고싶은 경우, 애초에 트리를 생성할 때부터 정렬기준을 넣어줘야 함.
        treeSet2.add(myUser1);
        treeSet2.add(myUser2);
        treeSet2.add(myUser3);

        System.out.println("IdComparator 기본 정렬");
        System.out.println(treeSet2);
    }
}
