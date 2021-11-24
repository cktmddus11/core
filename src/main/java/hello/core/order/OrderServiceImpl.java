package hello.core.order;

import hello.core.ResultDto;
import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{
    // 메모리 회원 리포지토리
    //private final MemberRepository memberRepository = new MemoryMemberRepository();
    // 고정 금액 할인 정책
    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    //TODO
    // AS-IS CODE : 추상클래스 뿐만 아니라 구현클래스까지 의존하고 있기 때문에 코드 수정이 필요했음 = OCP위반
    // 수정사항 11.21 주문값 생성시 할인정책을 적용하되
    // 기존에는 정액 할인 이었던 부분을 정률할인으로 변경
    //private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
    //TODO
    // TO-BE CODE : 추상클래스만 의존하도록 코드수정하여 구현클래스까지 의존하지 않도록 함 = OCP 준수
    // ** 클라이언트인 OrderServiceImpl 에 DiscountPolicy 의 구현 객체를 대신 생성하고 주입해야한다.
    private DiscountPolicy discountPolicy;
    private MemberRepository memberRepository;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }


    // 1. 주문 생성 요청이 오면
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        // 2. 주문 생성 요청한 회원 id로 회원 정보를 조회하고
        Member member = memberRepository.findById(memberId);

        if("F".equals(member.getRst())){
           // Order order = new Order("");
            Order order = new Order(member.getRst(), member.getRstMsg());
            return order;
        }


        // 3. 회원의 등급에 따라 할인 정책을 확인한 후
        int discountPrice = discountPolicy.discount(member, itemPrice);
        // 4. 최종 주문 금액을 포함한 주문 객체를 생성해서 반환한다.
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
