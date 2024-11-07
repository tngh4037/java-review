package adv1.control.join;

import static adv1.util.MyLogger.log;
import static adv1.util.ThreadUtils.sleep;

// 특정 스레드를 기다리게 하는 가장 간단한 방법: sleep()
// 한계)
// 1) 대기시간을 임의로 정하는 것이므로, 대기시간에 손해를 봄. (실제 처리시간은 1초걸렸는데, 무조건 지정한 시간만큼 대기)
// 2) 수행시간이 달라지는 경우(ex. 10초), 이에 대한 정확한 타이밍을 맞추기 어렵다.
public class JoinMainV2 {

    public static void main(String[] args) {
        log("Start");

        SumTask task1 = new SumTask(1, 50);
        SumTask task2 = new SumTask(51, 100);
        Thread thread1 = new Thread(task1, "thread-1");
        Thread thread2 = new Thread(task2, "thread-2");
        thread1.start();
        thread2.start();

        log("main 스레드 sleep()"); // 특정 스레드를 기다리게 하는 가장 간단한 방법: sleep() | ( But, 정확한 타이밍을 맞추어 기다리기 어려움. )
        sleep(3000);

        log("task1.result = " + task1.result);
        log("task2.result = " + task2.result);
        int sumAll = task1.result + task2.result;
        log("task1 + task2 = " + sumAll);

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
