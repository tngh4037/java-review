package thread.sync;

import static thread.util.MyLogger.log;
import static thread.util.ThreadUtils.sleep;

public class BankAccountV2 implements BankAccount {

    private int balance;

    public BankAccountV2(int initialBalance) {
        this.balance = initialBalance;
    }

    @Override
    public synchronized boolean withdraw(int amount) {
        log("거래 시작: " + getClass().getSimpleName());

        // 잔고가 출금액 보다 적으면, 진행하면 안됨.
        log("[검증 시작] 출금액: " + amount + ", 잔액: " + balance);
        if (balance < amount) {
            log("[검증 실패] 출금액: " + amount + ", 잔액: " + balance);
            return false;
        }

        // 잔고가 출금액 보다 많으면, 진행.
        log("[검증 완료] 출금액: " + amount + ", 잔액: " + balance);
        sleep(1000); // 출금에 걸리는 시간이라 가정.
        balance = balance - amount;
        log("[출금 완료] 출금액: " + amount + ", 잔액: " + balance);

        log("거래 종료");
        return true;
    }

    @Override
    public synchronized int getBalance() { // 참고) balance 값을 수정하는 withdraw() 메서드에 synchronized 가 걸려있기 때문에, balance에 대한 메모리 가시성 문제는 고민하지 않아도 된다. ( 여기서는, 하나의 스레드가 락을 획득하고 작업을 마칠때까지, 다른 스레드가 BankAccount 에서 어떠한 작업을 하지 않도록 하기 위해 synchronized 를 설정했다. 가시성 때문에 getBalance()에 synchronized 를 적용한게 아님. )
        return balance;
    }
}
