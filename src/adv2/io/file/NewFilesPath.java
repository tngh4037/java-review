package adv2.io.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

public class NewFilesPath {

    public static void main(String[] args) throws IOException {
        Path path = Path.of("temp/..");

        System.out.println("path = " + path); // 상대 경로 ( ex) temp\.. )
        System.out.println("Absolute path = " + path.toAbsolutePath()); // 절대 경로 ( ex) D:\study\temp\.. )
        System.out.println("Canonical path = " + path.toRealPath()); // 정규 경로 ( ex) D:\study )

        Stream<Path> pathStream = Files.list(path); // 여기서 Stream 은 I/O 에서의 스트림이 아닌, Stream API 를 말한다. ( Stream 이 파일 시스템 리소스를 처리하거나 외부 시스템과 상호작용하는 경우, 그 자원을 명시적으로 닫아줘야 한다. )
        List<Path> list = pathStream.toList();
        pathStream.close();

        for (Path p : list) {
            System.out.println( (Files.isRegularFile(p) ? "F" : "D") + " | " + p.getFileName() );
        }
    }
}
