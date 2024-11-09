package adv2.io.streams;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class PrintStreamEtcMain {

    public static void main(String[] args) throws FileNotFoundException {
        FileOutputStream fos = new FileOutputStream("temp/print.txt");
        PrintStream printStream = new PrintStream(fos);

        printStream.println("hello java!");
        printStream.println(10); // 내부적으로 String 으로 취급되어 변환되어 저장됨
        printStream.println(true); // 내부적으로 String 으로 취급되어 변환되어 저장됨
        printStream.printf("hello %s", "world");
        printStream.close();
    }
}
