package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
// 할인 정책 구현체 - 정액할인
public class FixDiscountPolicy implements DiscountPolicy{

    private int discountFixAmount = 1000; // 1000 원 할인

    @Override
    public int discount(Member member, int price) {
        return Grade.VIP == member.getGrade() ? discountFixAmount : 0;
    }
}
