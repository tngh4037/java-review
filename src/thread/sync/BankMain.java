package thread.sync;

import static thread.util.MyLogger.log;
import static thread.util.ThreadUtils.sleep;

public class BankMain {

    public static void main(String[] args) throws InterruptedException {
        // BankAccount account = new BankAccountV1(1000);
        // BankAccount account = new BankAccountV2(1000);
        BankAccount account = new BankAccountV3(1000);

        Thread t1 = new Thread(new WithdrawTask(account, 800), "t1");
        Thread t2 = new Thread(new WithdrawTask(account, 800), "t2");
        t1.start();
        t2.start();

        sleep(500); // 검증 완료까지 잠시 대기
        log("t1 state: " + t1.getState());
        log("t2 state: " + t2.getState());

        t1.join();
        t2.join();

        log("최종 잔액: " + account.getBalance()); // 200 or -600
    }
}

// 참고) 200이든 -600이든 둘 다 비정상이다.
// -600: 두 스레드가 거의 동시에 실행되지만, 아주 약간의 차이로 특정 스레드가 먼저 수행된 경우
// 200: 두 스레드가 완전히 동시에 수행된 경우
