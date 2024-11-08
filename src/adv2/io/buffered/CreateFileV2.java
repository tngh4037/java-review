package adv2.io.buffered;

import java.io.FileOutputStream;
import java.io.IOException;

public class CreateFileV2 {

    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream(BufferedConst.FILE_NAME);
        long startTime = System.currentTimeMillis();

        byte[] buffer = new byte[BufferedConst.BUFFER_SIZE]; // 버퍼사이즈: 8kb
        int bufferIndex = 0;

        for (int i = 0; i < BufferedConst.FILE_SIZE; i++) {
            buffer[bufferIndex] = 1; // 버퍼 사이즈만큼 버퍼에 데이터를 채운다.
            bufferIndex++;

            // 버퍼가 가득차면 쓰고 버퍼를 비운다
            if (bufferIndex == BufferedConst.BUFFER_SIZE) {
                fos.write(buffer);
                bufferIndex = 0;
            }
        }

        // 버퍼에 남은 부분 쓰기 (위 반복문에서 마지막에 버퍼가 가득차지 않고, 남아있을 수 있다.)
        if (bufferIndex > 0) {
            fos.write(buffer, 0, bufferIndex);
        }
        fos.close();

        long endTime = System.currentTimeMillis();
        System.out.println("File created: " + BufferedConst.FILE_NAME);
        System.out.println("File size: " + (BufferedConst.FILE_SIZE / 1024 / 1024) + "MB");
        System.out.println("Time taken: " + (endTime - startTime) + "ms");
    }
}
