package adv2.io.file.text;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class RealTextFileV1 {

    private static final String PATH = "temp/hello2.txt";

    public static void main(String[] args) throws IOException {
        String writeString = "ABC\n가나다";
        System.out.println("== Write String ==");
        System.out.println(writeString);

        Path path = Path.of(PATH);

        // 파일에 쓰기
        Files.writeString(path, writeString, StandardCharsets.UTF_8);

        // 파일에서 읽기
        String readString = Files.readString(path, StandardCharsets.UTF_8); // 단, 전체를 한 번에 조회하므로 대용량 파일에서는 메모리 문제가 발생할 수 있다.

        System.out.println("== Read String ==");
        System.out.println(readString);
    }
}
