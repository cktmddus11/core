package hello.core.order;

public interface OrderService {

    // 주문 생성해서 주문 결과 반환
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
