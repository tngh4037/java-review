package thread.executor.future;

import java.util.Random;
import java.util.concurrent.*;

import static thread.util.MyLogger.log;
import static thread.util.ThreadUtils.sleep;

public class CallableMainV1 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(1);
        Future<Integer> future = es.submit(new MyCallable()); // 작업으로 Callable 을 넘기려면 submit() 을 호출해야 한다.
        Integer result = future.get();
        log("result value = " + result);
        es.close();
    }

    static class MyCallable implements Callable<Integer> {

        @Override
        public Integer call() {
            log("Callable 시작");
            sleep(2000); // 작업에 소요되는 시간이라 가정
            int value = new Random().nextInt(10);
            log("create value = " + value);
            log("Callable 완료");

            return value;
        }
    }
}
