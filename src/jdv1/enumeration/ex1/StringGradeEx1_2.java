package jdv1.enumeration.ex1;

public class StringGradeEx1_2 {

    public static void main(String[] args) {
        int price = 10000;

        DiscountService discountService = new DiscountService();
        int basic = discountService.discount("BASIC", price);
        int gold = discountService.discount("GOLD", price);
        int diamond = discountService.discount("DIAMOND", price);

        System.out.println("BASIC 등급의 할인 금액: " + basic);
        System.out.println("GOLD 등급의 할인 금액: " + gold);
        System.out.println("DIAMOND 등급의 할인 금액: " + diamond);

        // 실수로 존재하지 않는 등급이 입력됨.
        int vip = discountService.discount("VIP", price);
        System.out.println("VIP 등급의 할인 금액: " + vip);
        
        // 오타를 입력할 수 있음
        int diamond2 = discountService.discount("DIAMONDD", price);
        System.out.println("DIAMONDD 등급의 할인 금액: " + diamond2);
        
        // 소문자 입력
        int gold2 = discountService.discount("gold", price);
        System.out.println("gold 등급의 할인 금액: " + gold2);
    }
}

// StringGrade 문자열 상수로 등급을 정해놨다고 하더라도, String 타입은 어떤 문자열이든 입력할 수 있기 때문에 컴파일 오류가 발생하지 않는다.