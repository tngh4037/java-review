package adv1.executor.poolsize;

import adv1.executor.ExecutorUtils;
import adv1.executor.RunnableTask;

import java.util.concurrent.*;

import static adv1.util.MyLogger.log;
import static adv1.util.ThreadUtils.sleep;

public class PoolSizeMainV3 {

    public static void main(String[] args) {
        // ExecutorService es = Executors.newCachedThreadPool();
        ExecutorService es = new ThreadPoolExecutor(0, Integer.MAX_VALUE,
                3, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>());

        log("pool 생성");
        ExecutorUtils.printState(es);

        for (int i = 1; i <= 4; i++) {
            String taskName = "task" + i;
            es.execute(new RunnableTask(taskName));
            ExecutorUtils.printState(es, taskName);
        }

        sleep(3000);
        log("== 작업 수행 완료 ==");
        ExecutorUtils.printState(es);

        sleep(3000);
        log("== maximumPoolSize 대기 시간 초과 ==");
        ExecutorUtils.printState(es);

        es.close();
        log("== shutdown 완료 ==");
        ExecutorUtils.printState(es);
    }
}
