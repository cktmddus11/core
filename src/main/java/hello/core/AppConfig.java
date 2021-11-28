package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 구현 객체를 생성하고 연결하는 책임을 가지는 별도의 설정 클래스
// 관심사 분리가 이루어짐
// AppConfig : memberService에게 어떤 member관리 방식을 이용할건지 지정함(DB or Memory)
// MemberServiceImpl : memberRepository를 이용해서 해당 회원 관련 역할만 하면 됨(DB인지 Memory인지 알필요없음).
@Configuration
public class AppConfig {
    // 생성한 객체 인스턴수와 참조(레퍼런스)를 생성자를 통해서 주입(연결)해준다.
    /*public MemberService memberService(){
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService(){
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }*/


    //TODO
    //위의 코드 중복 제거, 역할에 따른 구현 잘보이도록 리펙토링
    @Bean // 스프링 컨테이너에 스프링 빈으로 등록
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }
    @Bean // 빈이름 - 메스드 이름을 사용, 이름 중복 불가능
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository()
                                    , discountPolicy());
    }
    @Bean
    public DiscountPolicy discountPolicy() {
        //return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

}
