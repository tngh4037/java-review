package adv1.executor.test;

public class NewOrderServiceTestMain {

    public static void main(String[] args) {
        String orderNo = "Order#1234";  // 예시 주문 번호
        NewOrderService orderService = new NewOrderService();
        orderService.order(orderNo);
    }
}