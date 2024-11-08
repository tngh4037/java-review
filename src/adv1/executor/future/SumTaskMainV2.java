package adv1.executor.future;

import java.util.concurrent.*;

import static adv1.util.MyLogger.log;

public class SumTaskMainV2 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(2);

        Future<Integer> future1 = es.submit(new SumTask(1, 50));
        Future<Integer> future2 = es.submit(new SumTask(51, 100));

        Integer sum1 = future1.get();
        Integer sum2 = future2.get();

        log("task1.result = " + sum1);
        log("task2.result = " + sum2);

        int sumAll = sum1 + sum2;
        log("task1 + task2 = " + sumAll);
        log("End");

        es.close();
    }

    static class SumTask implements Callable<Integer> {

        int startValue;
        int endValue;

        public SumTask(int startValue, int endValue) {
            this.startValue = startValue;
            this.endValue = endValue;
        }

        @Override
        public Integer call() throws Exception {
            log("작업 시작");

            Thread.sleep(2000);

            int sum = 0;
            for (int i = startValue; i <= endValue; i++) {
                sum += i;
            }

            log("작업 완료 result = " + sum);
            return sum;
        }
    }

}