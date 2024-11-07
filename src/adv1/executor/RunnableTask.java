package adv1.executor;

import static adv1.util.MyLogger.log;
import static adv1.util.ThreadUtils.sleep;

public class RunnableTask implements Runnable {

    private final String name;
    private int sleepMs = 1000;

    public RunnableTask(String name) {
        this.name = name;
    }

    public RunnableTask(String name, int sleepMs) {
        this.name = name;
        this.sleepMs = sleepMs;
    }

    @Override
    public void run() {
        log(name + " 시작");
        sleep(sleepMs); // sleepMs 초간 걸리는 작업이라 가정 (작업 시간 시뮬레이션)
        log(name + " 완료");
    }
}
