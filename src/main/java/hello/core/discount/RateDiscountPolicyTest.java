package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RateDiscountPolicyTest {

    DiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야한다. ")
    public void vip_o(){
        // given
        Member member= new Member(1L, "차승연",Grade.VIP);
        // when
        int discount = discountPolicy.discount(member,10000);
        // then
        Assertions.assertEquals(discount, 1000);
    }

    @Test
    @DisplayName("VIP가 아니면 10%할인이 적용되지 않아야한다. ")
    public void vip_x(){
        Member member= new Member(1L, "차승연",Grade.BASIC);
        int discount = discountPolicy.discount(member,10000);
        Assertions.assertEquals(discount, 1000); // assertEquals : 예상값이 실제 값이랑 동일한가?
                                // 예상값,   실제값
    }



}
