package adv2.annotation.basic;

import adv1.util.MyLogger;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface AnnoElement {
    String value();
    int count() default 0;
    String[] tags() default {};

    // MyLogger data(); // 다른 타입은 적용X
    // Class<? extends MyLogger> annoData() default MyLogger.class; // 클래스 정보는 가능
}
