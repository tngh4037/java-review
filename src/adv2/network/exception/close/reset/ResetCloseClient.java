package adv2.network.exception.close.reset;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketException;

import static adv2.util.MyLogger.log;

public class ResetCloseClient {

    public static void main(String[] args) throws IOException, InterruptedException {
        Socket socket = new Socket("localhost", 12345);
        InputStream input = socket.getInputStream();
        OutputStream output = socket.getOutputStream();
        log("소켓 연결: " + socket);

        // client <- server: FIN
        Thread.sleep(1000); // 서버가 close() 호출할 때 까지 잠시 대기

        // client -> server: PUSH[1]
        output.write(1);

        // client <- server: RST
        Thread.sleep(1000); // RST 메시지를 받을 때 까지 잠시 대기

        try {
            // RST를 받은 다음에 read()를 하면,
            //  - Window: "java.net.SocketException: 현재 연결은 사용자의 호스트 시스템의 소프트웨어의 의해 중단되었습니다." 발생
            //  - Mac: "java.net.SocketException: Connection reset" 발생
            int read = input.read();
        } catch (SocketException e) {
            e.printStackTrace();
        }

        try {
            // RST를 받은 다음에 write()를 하면,
            // - Window: "java.net.SocketException: 현재 연결은 사용자의 호스트 시스템의 소프트웨어의 의해 중단되었습니다." 발생
            // - Mac: "java.net.SocketException: Broken pipe" 발생
            output.write(1);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }
}
