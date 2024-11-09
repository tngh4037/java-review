package adv2.io.text;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class ReaderWriterMainV2 {

    public static void main(String[] args) throws IOException {
        String writeString = "ABC";
        System.out.println("write String: " + writeString);

        // 파일에 쓰기
        FileOutputStream fos = new FileOutputStream("temp/hello.txt");
        OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);

        osw.write(writeString);
        osw.close();

        // 파일에서 읽기
        FileInputStream fis = new FileInputStream("temp/hello.txt");
        InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);

        StringBuilder content = new StringBuilder();
        int ch;
        while ((ch = isr.read()) != -1) {
            // read() 메서드는 한 문자씩 읽어들여서 char 타입으로 반환한다. 그런데 실제 반환 타입은 int이다. (EOF를 표현하기 위해)
            // 따라서 문자로 보기위해서는 캐스팅해야 한다.
            content.append((char) ch);
        }
        isr.close();

        System.out.println("read String: " + content);
    }
}
