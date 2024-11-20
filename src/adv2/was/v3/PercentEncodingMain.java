package adv2.was.v3;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class PercentEncodingMain {

    public static void main(String[] args) {
        String encoded = URLEncoder.encode("가", StandardCharsets.UTF_8);
        System.out.println("encoded = " + encoded);

        String decode = URLDecoder.decode(encoded, StandardCharsets.UTF_8);
        System.out.println("decode = " + decode);
    }
}
