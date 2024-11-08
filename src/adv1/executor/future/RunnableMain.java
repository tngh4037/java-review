package adv1.executor.future;

import java.util.Random;

import static adv1.util.MyLogger.log;
import static adv1.util.ThreadUtils.sleep;

public class RunnableMain {

    public static void main(String[] args) throws InterruptedException {
        MyRunnable task = new MyRunnable();
        Thread thread = new Thread(task, "Thread-1");
        thread.start();
        thread.join();

        int result = task.value;
        log("result value = " + result);
    }

    static class MyRunnable implements Runnable {

        int value;

        @Override
        public void run() {
            log("Runnable 시작");

            sleep(2000); // 작업에 소요되는 시간이라 가정

            value = new Random().nextInt(10);
            log("create value = " + value);

            log("Runnable 완료");
        }
    }
}