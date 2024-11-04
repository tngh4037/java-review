package jdv1.nested.nested;

public class NestedOuterMain {

    public static void main(String[] args) {
        NestedOuter nestedOuter = new NestedOuter();
        NestedOuter.Nested nested = new NestedOuter.Nested();
        nested.print();

        System.out.println("nestedClass = " + nested.getClass());
    }
}
