package adv2.charset;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Set;
import java.util.SortedMap;

public class AvailableCharsetsMain {

    public static void main(String[] args) {
        // 이용 가능한 모든 Charset (자바가 제공하는 것 + OS가 제공하는 것)
        SortedMap<String, Charset> charsets = Charset.availableCharsets();
        for (String charsetName : charsets.keySet()) {
            System.out.println("charsetName = " + charsetName);
        }

        System.out.println("=======");
        
        // 이용 가능한 Charset - 문자로 조회(대소문자 구분X (ex. MS949, ms949))
        Charset charset1 = Charset.forName("MS949");
        System.out.println("charset1 = " + charset1);
        // 별칭 조회
        Set<String> aliases = charset1.aliases();
        for (String alias : aliases) {
            System.out.println("alias = " + alias);
        }

        // UTF-8 문자로 조회
        Charset charset2 = Charset.forName("UTF-8");
        // Charset charset2 = Charset.forName("utf-8");
        System.out.println("charset2 = " + charset2);

        // 상수로 조회
        Charset charset3 = StandardCharsets.UTF_8;
        System.out.println("charset3 = " + charset3);

        System.out.println("=======");

        // 시스템의 기본 Charset 조회
        Charset defaultCharset = Charset.defaultCharset();
        System.out.println("defaultCharset = " + defaultCharset);
    }
}
