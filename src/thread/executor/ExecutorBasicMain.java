package thread.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import static thread.util.MyLogger.log;
import static thread.util.ThreadUtils.sleep;

public class ExecutorBasicMain {

    public static void main(String[] args) {
        ExecutorService es = new ThreadPoolExecutor(2, 2, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());
        log("== 초기 상태 ==");
        ExecutorUtils.printState(es);

        es.submit(new RunnableTask("taskA"));
        es.submit(new RunnableTask("taskB"));
        es.submit(new RunnableTask("taskC"));
        es.submit(new RunnableTask("taskD"));
        log("== 작업 수행 중 ==");
        ExecutorUtils.printState(es);

        sleep(3000);

        log("== 작업 수행 완료 ==");
        ExecutorUtils.printState(es);

        es.close();

        log("== shutdown 완료 ==");
        ExecutorUtils.printState(es);
    }
}
