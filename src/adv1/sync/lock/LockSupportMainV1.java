package adv1.sync.lock;

import java.util.concurrent.locks.LockSupport;

import static adv1.util.MyLogger.log;
import static adv1.util.ThreadUtils.sleep;

public class LockSupportMainV1 {

    public static void main(String[] args) {
        Thread thread1 = new Thread(new ParkTest(), "Thread-1");
        thread1.start();

        sleep(100); // 잠시 대기하여 Thread-1 이 park 상태에 빠질 시간을 준다.
        log("Thread-1 state: " + thread1.getState()); // WAITING

        log("main -> unpark(Thread-1)");
        LockSupport.unpark(thread1); // unpark 할 대상 스레드를 지정해주면 된다.
    }

    static class ParkTest implements Runnable {

        @Override
        public void run() {
            log("park 시작");
            LockSupport.park(); // 이 코드를 호출한 스레드는 RUNNABLE -> WAITING

            log("park 종료, state: " + Thread.currentThread().getState()); // RUNNABLE ( WAITING -> RUNNABLE )
            log("인터럽트 상태: " + Thread.currentThread().isInterrupted()); // false
        }
    }
}

