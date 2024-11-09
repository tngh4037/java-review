package adv2.io.text;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class ReaderWriterMainV4 {

    private static final int BUFFER_SIZE = 8192;

    public static void main(String[] args) throws IOException {
        String writeString = "ABC\n가나다";
        System.out.println("== Write String ==");
        System.out.println(writeString);

        // 파일에 쓰기
        FileWriter fw = new FileWriter("temp/hello.txt", StandardCharsets.UTF_8);
        BufferedWriter bw = new BufferedWriter(fw, BUFFER_SIZE);
        bw.write(writeString);
        bw.close();

        // 파일에서 읽기
        StringBuilder content = new StringBuilder();
        FileReader fr = new FileReader("temp/hello.txt", StandardCharsets.UTF_8);
        BufferedReader br = new BufferedReader(fr, BUFFER_SIZE);

        String line;
        while ((line = br.readLine()) != null) { // 라인 단위로 반환하는 경우, 반환 타입이 String 이다. 따라서 파일의 끝을 나타낼 때, -1을 반환 하지 않는다. 대신 파일의 끝에 도달하면 null을 반환한다.
            content.append(line).append("\n"); // 라인 단위로 반환하면 라인이 제거되기에 넣어주었다.
        }
        br.close();

        System.out.println("== Read String ==");
        System.out.println(content);
    }
}
