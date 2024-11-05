package jdv1.enumeration.ref3;

public enum Grade {
    BASIC(10),
    GOLD(20),
    DIAMOND(30),
    VIP(40);

    private final int discountPercent;

    Grade(int discountPercent) {
        this.discountPercent = discountPercent;
    }

    public int discount(int price) {
        return price * discountPercent / 100;
    }
}
