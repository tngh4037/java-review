package adv2.charset;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class EncodingMain1 {

    private static final Charset EUC_KR = Charset.forName("EUC-KR");
    private static final Charset MS_949 = Charset.forName("MS949");

    public static void main(String[] args) {
        System.out.println("=== ASCII 영문 처리 ===");
        encoding("A", StandardCharsets.US_ASCII);
        encoding("A", StandardCharsets.ISO_8859_1);
        encoding("A", EUC_KR);
        encoding("A", StandardCharsets.UTF_8);
        encoding("A", StandardCharsets.UTF_16BE);

        System.out.println("== 한글 지원 ==");
        encoding("가", EUC_KR);
        encoding("가", MS_949);
        encoding("가", StandardCharsets.UTF_8);
        encoding("가", StandardCharsets.UTF_16BE);
    }

    private static void encoding(String text, Charset charset) {
        byte[] bytes = text.getBytes(charset); // 인코딩 ( 문자를 컴퓨터가 이해할 수 있는 숫자(byte)로 변경 ), 문자를 byte로 변경하려면 반드시 문자 집합이 필요하다. 따라서 어떤 문자 집합을 참고해서 byte로 변경할지 정해야 한다.
        System.out.printf("%s -> [%s] 인코딩 -> %s %sbyte\n", text, charset, Arrays.toString(bytes), bytes.length);
    }
}

// 문자 집합을 지정하지 않으면 현재 시스템에서 사용하는 기본 문자 집합을 인코딩에 사용한다.
//
// ex)
// String str = "hello";
// byte[] bytes = str.getBytes(); // 시스템의 기본 Charset 로 인코딩 된다.
// System.out.println("Arrays.toString(bytes) = " + Arrays.toString(bytes));
