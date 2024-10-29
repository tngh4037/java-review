package thread.sync.lock;

import java.util.concurrent.locks.LockSupport;

import static thread.util.MyLogger.log;
import static thread.util.ThreadUtils.sleep;

public class LockSupportMainV2 {

    public static void main(String[] args) {
        Thread thread1 = new Thread(new ParkTest(), "Thread-1");
        thread1.start();

        sleep(100); // 잠시 대기하여 Thread-1 이 park 상태에 빠질 시간을 준다.
        log("Thread-1 state: " + thread1.getState()); // WAITING

        thread1.interrupt(); // 인터럽트를 걸어서 깨울 수 있다.
    }

    static class ParkTest implements Runnable {

        @Override
        public void run() {
            log("park 시작");
            LockSupport.park(); // 이 코드를 호출한 스레드는 RUNNABLE -> WAITING

            log("park 종료, state: " + Thread.currentThread().getState()); // RUNNABLE ( WAITING -> RUNNABLE )
            log("인터럽트 상태: " + Thread.currentThread().isInterrupted()); // 인터럽트 상태: true
        }
    }
}

