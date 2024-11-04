package jdv1.nested.anonymous;

import jdv1.nested.local.Printer;

public class AnonymousOuter {

    private int outInstanceVar = 3;

    public void process(int paramVar) {
        int localVar = 1;

        /*
        class LocalPrinter implements Printer { // 선언
            int value = 0;

            @Override
            public void print() {
                System.out.println("value = " + value);
                System.out.println("localVar = " + localVar);
                System.out.println("paramVar = " + paramVar);
                System.out.println("outInstanceVar = " + outInstanceVar);
            }
        }

        LocalPrinter printer = new LocalPrinter(); // 생성
        printer.print();
        */

        // 익명 클래스
        Printer printer = new Printer() { // 선언(인터페이스의 구현체를 이름없이 만들고) + 생성(by new)
            int value = 0;

            @Override
            public void print() {
                System.out.println("value = " + value);
                System.out.println("localVar = " + localVar);
                System.out.println("paramVar = " + paramVar);
                System.out.println("outInstanceVar = " + outInstanceVar);
            }
        };
        
        printer.print();
        System.out.println("printer.class = " + printer.getClass());
    }

    public static void main(String[] args) {
        AnonymousOuter main = new AnonymousOuter();
        main.process(2);
    }
}
