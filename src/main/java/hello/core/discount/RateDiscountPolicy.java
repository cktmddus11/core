package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
// 할인 정책 구현체 - 정률할인
public class RateDiscountPolicy implements DiscountPolicy{

    private int discountPercent = 10; // 10% 할인

    @Override
    public int discount(Member member, int price) { // 100,000 / 100 = 1000
        return Grade.VIP == member.getGrade() ? price * discountPercent / 100 : 0;
    }
}
