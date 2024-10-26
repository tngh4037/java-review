package thread.start;

import static thread.util.MyLogger.log;

// 특정 클래스 안에서만 사용되는 경우 이렇게 중첩 클래스를 사용하면 된다.
public class InnerRunnableMainV1 {

    public static void main(String[] args) {
        log("main() start");

        MyRunnable runnable = new MyRunnable();
        Thread thread = new Thread(runnable);
        thread.start();

        log("main() end");
    }

    static class MyRunnable implements Runnable {

        @Override
        public void run() {
            log("run()");
        }
    }
}
