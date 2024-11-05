package jdv1.enumeration.test;

public enum AuthGrade {
    GUEST(1, "손님"),
    LOGIN(2, "로그인 회원"),
    ADMIN(3, "관리자");

    AuthGrade(int level, String description) {
        this.level = level;
        this.description = description;
    }

    private final int level;
    private final String description;

    public int getLevel() {
        return level;
    }

    public String getDescription() {
        return description;
    }
}
