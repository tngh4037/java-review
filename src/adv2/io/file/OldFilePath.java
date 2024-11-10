package adv2.io.file;

import java.io.File;
import java.io.IOException;

public class OldFilePath {

    public static void main(String[] args) throws IOException {
        File file = new File("temp/..");
        System.out.println("path = " + file.getPath());

        // 절대 경로 (프로그램 시작부터의 경로) (ex. D:\study\temp\..)
        System.out.println("Absolute path = " + file.getAbsolutePath());

        // 정규 경로 (.. 등을 전부 계산한 경로) (ex. D:\study)
        System.out.println("Canonical path = " + file.getCanonicalPath());

        // 디렉토리 내 모든 파일/디렉토리 목록 반환
        File[] files = file.listFiles();
        for (File f : files) {
            System.out.println( (f.isFile() ? "F" : "D") + " | " + f.getName() );
        }
    }
}
