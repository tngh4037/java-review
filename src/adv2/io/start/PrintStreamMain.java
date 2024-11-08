package adv2.io.start;

import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

public class PrintStreamMain {

    public static void main(String[] args) throws IOException {
        PrintStream printStream = System.out;

        byte[] bytes = "Hello!\n".getBytes(StandardCharsets.UTF_8);
        printStream.write(bytes);
        
        // 부가 기능
        printStream.println("Print!");
    }
}