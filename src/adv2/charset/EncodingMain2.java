package adv2.charset;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class EncodingMain2 {

    private static final Charset EUC_KR = Charset.forName("EUC-KR");
    private static final Charset MS_949 = Charset.forName("MS949");

    public static void main(String[] args) {
        System.out.println("== 영문 ASCII 인코딩 ==");
        test("A", StandardCharsets.US_ASCII, StandardCharsets.US_ASCII);
        test("A", StandardCharsets.US_ASCII, StandardCharsets.ISO_8859_1); // ISO_8859_1: ASCII 포함
        test("A", StandardCharsets.US_ASCII, EUC_KR); // EUC_KR: ASCII 포함
        test("A", StandardCharsets.US_ASCII, MS_949); // MS_949: ASCII 포함
        test("A", StandardCharsets.US_ASCII, StandardCharsets.UTF_8); // UTF_8: ASCII 포함
        test("A", StandardCharsets.US_ASCII, StandardCharsets.UTF_16BE); // 디코딩 실패 (호환 X)

        System.out.println("== 한글 인코딩 - 기본 ==");
        test("가", StandardCharsets.US_ASCII, StandardCharsets.US_ASCII); // 한글 지원 X (이미 인코딩에서 X)
        test("가", StandardCharsets.ISO_8859_1, StandardCharsets.ISO_8859_1); // 한글 지원 X (이미 인코딩에서 X)
        test("가", EUC_KR, EUC_KR); // 한글 지원 O
        test("가", MS_949, MS_949); // 한글 지원 O
        test("가", StandardCharsets.UTF_8, StandardCharsets.UTF_8); // 한글 지원 O
        test("가", StandardCharsets.UTF_16BE, StandardCharsets.UTF_16BE); // 한글 지원 O

        System.out.println("== 한글 인코딩 - 복잡한 문자 ==");
        test("쀍", EUC_KR, EUC_KR); // 한글 지원 O, EUC_KR 에는 지원되지 않는 문자
        test("쀍", MS_949, MS_949); // 한글 지원 O, 한글 모두 포함
        test("쀍", StandardCharsets.UTF_8, StandardCharsets.UTF_8); // 한글 지원 O, 한글 모두 포함
        test("쀍", StandardCharsets.UTF_16BE, StandardCharsets.UTF_16BE); // 한글 지원 O, 한글 모두 포함

        System.out.println("== 한글 인코딩 - 디코딩이 다른 경우 ==");
        test("가", EUC_KR, MS_949); // MS_949는 EUK-KR을 확장
        test("뷁", MS_949, EUC_KR); // 인코딩 O, 디코딩 X ( EUK-KR 에서는 지원하지 X )
        test("가", EUC_KR, StandardCharsets.UTF_8); // 서로 호환 X ( UTF_8 은 EUK-KR 을 확장해서 만든게 아님. )
        test("가", MS_949, StandardCharsets.UTF_8); // 서로 호환 X ( UTF_8 은 MS_949 을 확장해서 만든게 아님. )

        System.out.println("== 영문 인코딩 - 디코딩이 다른 경우 ==");
        test("A", EUC_KR, StandardCharsets.UTF_8); // 둘다 ASCII 지원
        test("A", MS_949, StandardCharsets.UTF_8); // 둘다 ASCII 지원
        test("A", StandardCharsets.UTF_8, MS_949); // 둘다 ASCII 지원
        test("A", StandardCharsets.UTF_8, StandardCharsets.UTF_16BE); // 호환 X
    }

    private static void test(String text, Charset encodingCharset, Charset decodingCharset) {
        byte[] encoded = text.getBytes(encodingCharset); // encoding
        String decoded = new String(encoded, decodingCharset); // decoding // 항상 (문자 -> 바이트, 바이트 -> 문자)시, 문자 집합이 있어야 한다.

        System.out.printf("%s -> [%s] 인코딩 -> %s %sbyte -> [%s] 디코딩 -> %s\n",
                text, encodingCharset,
                Arrays.toString(encoded), encoded.length,
                decodingCharset, decoded);
    }
}
