package thread.util;

import static thread.util.MyLogger.log;

public final class ThreadUtils {

    private ThreadUtils() {}

    public static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            log("인터럽트 발생, " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
