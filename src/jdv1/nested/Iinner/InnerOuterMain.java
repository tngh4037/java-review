package jdv1.nested.Iinner;

public class InnerOuterMain {

    public static void main(String[] args) {
        InnerOuter outer1 = new InnerOuter();
        InnerOuter outer2 = new InnerOuter();
        InnerOuter outer3 = new InnerOuter();

        InnerOuter.Inner inner = outer1.new Inner(); // 생성할 때, 자신이 소속될 바깥 클래스의 인스턴스를 알아야 한다. 이렇게 생성해야, inner 내부에서 outer에 대한 참조를 가지고 있을 수 있다.
        inner.print();

        System.out.println("innerClass = " + inner.getClass());
    }
}
