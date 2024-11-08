package adv2.io.text;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class ReaderWriterMainV1 {

    public static void main(String[] args) throws IOException {
        String writeString = "ABC";

        // String -> byte (인코딩 (UTF_8))
        byte[] writeBytes = writeString.getBytes(StandardCharsets.UTF_8);
        System.out.println("write String: " + writeString); // ABC
        System.out.println("write bytes: " + Arrays.toString(writeBytes)); // [65, 66, 67]

        // 파일에 쓰기
        FileOutputStream fos = new FileOutputStream("temp/hello.txt");
        fos.write(writeBytes);
        fos.close();

        System.out.println("======================================");

        // 파일에서 읽기
        FileInputStream fis = new FileInputStream("temp/hello.txt");
        byte[] readBytes = fis.readAllBytes();
        fis.close();
        
        // byte -> String (디코딩 (UTF_8))
        String readString = new String(readBytes, StandardCharsets.UTF_8);
        System.out.println("read bytes = " + Arrays.toString(readBytes));
        System.out.println("read String = " + readString);
    }
}
