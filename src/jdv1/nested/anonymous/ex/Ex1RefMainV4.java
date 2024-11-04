package jdv1.nested.anonymous.ex;

import java.util.Random;

public class Ex1RefMainV4 {

    public static void hello(Process process) {
        System.out.println("프로그램 시작"); // 변하지 않는 부분
        process.run(); // 변하는 부분
        System.out.println("프로그램 종료"); // 변하지 않는 부분
    }

    public static void main(String[] args) {

        hello(() -> {
            // 코드 조각 시작
            int randomValue = new Random().nextInt(6);
            System.out.println("주사위 = " + randomValue);
            // 코드 조각 종료
        });

        hello(() -> {
            // 코드 조각 시작
            for (int i = 0; i < 3; i++) {
                System.out.println("i = " + i);
            }
            // 코드 조각 종료
        });
    }
}
