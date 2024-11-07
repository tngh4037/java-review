package adv1.executor.poolsize;

import adv1.executor.ExecutorUtils;
import adv1.executor.RunnableTask;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static adv1.util.MyLogger.log;

public class PoolSizeMainV2 {

    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(2);

        log("pool 생성");
        ExecutorUtils.printState(es);

        for (int i = 1; i <= 6; i++) {
            String taskName = "task" + i;
            es.execute(new RunnableTask(taskName));
            ExecutorUtils.printState(es, taskName);
        }

        es.close();
        log("== shutdown 완료 ==");
    }
}
