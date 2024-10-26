package thread.start;

import static thread.util.MyLogger.log;

// 람다
public class InnerRunnableMainV3 {

    public static void main(String[] args) {
        log("main() start");

        Thread thread = new Thread(() -> log("run()"));
        thread.start();

        log("main() end");
    }
}
