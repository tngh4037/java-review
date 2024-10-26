package thread.control.join;

import static thread.util.MyLogger.log;
import static thread.util.ThreadUtils.sleep;

// 특정 스레드를 기다리게 하는 더 나은 방법: join(millis)
public class JoinMainV4 {

    public static void main(String[] args) throws InterruptedException {
        log("Start");

        SumTask task1 = new SumTask(1, 50);
        Thread thread1 = new Thread(task1, "thread-1");
        thread1.start();

        // 스레드가 종료(TERMINATED)할 때 까지 메인스레드는 지정된 시간동안만 대기(TIMED_WAITING), 지정된 시간 이후에는 다시 RUNNABLE 로 상태 천이
        log("join(1000) - main 스레드가 thread1 종료까지 1초 대기");
        thread1.join(1000);
        log("main 스레드 대기 완료");

        log("task1.result = " + task1.result); // 0

        log("End");
    }

    static class SumTask implements Runnable {

        private final int startValue;
        private final int endValue;
        private int result;

        public SumTask(int startValue, int endValue) {
            this.startValue = startValue;
            this.endValue = endValue;
        }

        @Override
        public void run() {
            log("작업 시작");

            sleep(2000); // 뭔가 처리가 걸린다고 가정

            int sum = 0;
            for (int i = startValue; i <= endValue; i++) {
                sum += i;
            }
            result = sum;

            log("작업 완료 result = " + result);
        }
    }
}
