package thread.start;

public class HelloRunnableMain {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + ": main() start");

        HelloRunnable runnable = new HelloRunnable(); // 작업과 스레드를 분리 (작업이 따로 인터페이스로 분리된 것, Runnable 객체를 생성하고 이를 Thread 에 전달)
        Thread thread = new Thread(runnable);
        thread.start();

        System.out.println(Thread.currentThread().getName() + ": main() end");
    }
}
