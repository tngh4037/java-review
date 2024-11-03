package thread.executor.poolsize;

import thread.executor.ExecutorUtils;
import thread.executor.RunnableTask;

import java.util.concurrent.*;

import static thread.util.MyLogger.log;

public class PoolSizeMainV4 {

    // static final int TASK_SIZE = 1100; // 1. 일반 ( 100개까지 기본 스레드를 생성하고, 큐에 1000개 까지 담는다. ) ==> time: 약 11초
    // static final int TASK_SIZE = 1200; // 2. 긴급 ( 기본 스레드 개수가 가득차고, 큐도 가득차면, 초과스레드를 100개까지 생성한다. ) ==> time: 약 6초 (초과스레드 합류)
    static final int TASK_SIZE = 1201; // 3. 거절 ( 초과 스레드도 다 가용중인데 요청이 들어오면 거절한다. ) ==> time: 약 6초

    public static void main(String[] args) {
        ExecutorService es = new ThreadPoolExecutor(100, 200,
                60, TimeUnit.SECONDS, new ArrayBlockingQueue<>(1000));
        ExecutorUtils.printState(es);

        long startMs = System.currentTimeMillis();

        for (int i = 1; i <= TASK_SIZE; i++) {
            String taskName = "task" + i;
            try {
                es.execute(new RunnableTask(taskName));
                ExecutorUtils.printState(es, taskName);
            } catch (RejectedExecutionException e) {
                log(taskName + " -> " + e); // task1201 -> java.util.concurrent.RejectedExecutionException
            }
        }
        
        es.close();
        long endMs = System.currentTimeMillis();
        log("time: " + (endMs - startMs));
    }
}
