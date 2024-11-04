package jdv1.nested.local;

public class LocalOuterV2 {

    private int outInstanceVar = 3;

    public void process(int paramVar) {
        int localVar = 1;

        class LocalPrinter implements Printer { // 내부 클래스를 포함한 중첩 클래스들도 일반 클래스처럼 인터페이스를 구현하거나, 부모 클래스를 상속할 수 있다.
            int value = 0;

            @Override
            public void print() {
                System.out.println("value = " + value);
                System.out.println("localVar = " + localVar);
                System.out.println("paramVar = " + paramVar);
                System.out.println("outInstanceVar = " + outInstanceVar);
            }
        }

        LocalPrinter printer = new LocalPrinter();
        printer.print();
        System.out.println("printer.class = " + printer.getClass());
    }

    public static void main(String[] args) {
        LocalOuterV2 localOuter = new LocalOuterV2();
        localOuter.process(2);
    }
}
