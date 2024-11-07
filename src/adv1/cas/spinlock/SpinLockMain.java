package adv1.cas.spinlock;

import static adv1.util.MyLogger.log;
import static adv1.util.ThreadUtils.sleep;

public class SpinLockMain {

    public static void main(String[] args) {
        // SpinLockBad spinLock = new SpinLockBad();
        SpinLock spinLock = new SpinLock();

        Runnable task = new Runnable() {

            @Override
            public void run() {
                spinLock.lock();

                try {
                    // critical section
                    log("비즈니스 로직 실행");
                    sleep(1); // 참고) 오래 걸리는 로직에서 스핀 락을 사용하면 안된다.
                } finally {
                    spinLock.unlock();
                }
            }
        };

        Thread t1 = new Thread(task, "Thread-1");
        Thread t2 = new Thread(task, "Thread-2");

        t1.start();
        t2.start();
    }
}
