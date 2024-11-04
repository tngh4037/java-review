package jdv1.nested.local;

public class LocalOuterV1 {

    private int outInstanceVar = 3;

    public void process(int paramVar) {
        int localVar = 1;

        class LocalPrinter { // 지역 클래스는 (지역 변수 처럼) 접근 제어자를 사용할 수 없다.
            int value = 0;

            public void printData() {
                System.out.println("value = " + value);
                System.out.println("localVar = " + localVar);
                System.out.println("paramVar = " + paramVar);
                System.out.println("outInstanceVar = " + outInstanceVar); // System.out.println("outInstanceVar = " + LocalOuterV1.this.outInstanceVar);
            }
        }

        LocalPrinter printer = new LocalPrinter();
        printer.printData();
    }

    public static void main(String[] args) {
        LocalOuterV1 localOuter = new LocalOuterV1();
        localOuter.process(2);
    }
}

// 지역 클래스는 외부 클래스의 멤버에 접근할 수 있으며, 메서드의 파라미터와 지역 변수에도 접근할 수 있다.
