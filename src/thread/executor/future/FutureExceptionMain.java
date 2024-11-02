package thread.executor.future;

import java.util.concurrent.*;

import static thread.util.MyLogger.log;
import static thread.util.ThreadUtils.sleep;

public class FutureExceptionMain {

    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(1);
        log("작업 전달");
        Future<Integer> future = es.submit(new ExCallable());
        sleep(1000); // ( 예외 발생 후 future 의 상태를 보기 위해 ) 잠시 대기

        try {
            log("future.get() 호출 시도, future.state(): " + future.state());
            Integer result = future.get();
            log("result value = " + result);
        } catch (InterruptedException e) { // 대기 중에 현재 스레드가 인터럽트된 경우 발생
            throw new RuntimeException(e);
        } catch (ExecutionException e) { // 작업 중 발생하는 예외는 ExecutionException 로 터진다.
            log("e = " + e);

            // 실제 future 실행 중에 발생한 예외는 원인 예외(cause)로 확인할 수 있다.
            Throwable cause = e.getCause(); // ExecutionException 이 왜 발생했는지에 대한 원본 예외
            log("cause = " + cause);
        }

        es.close();
    }

    static class ExCallable implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            log("Callable 실행, 예외 발생");
            throw new IllegalStateException("ex!");
        }
    }

}
