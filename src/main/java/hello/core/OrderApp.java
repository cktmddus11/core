package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class OrderApp  {
    public static void main(String[] args){
        //MemberService memberService = new MemberServiceImpl();
        //OrderService orderService = new OrderServiceImpl();

        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        long memberId = 1L;
        Member member = new Member(memberId, "차승연",  Grade.VIP);
        memberService.join(member);
//
//        long memberId2 = 2L;
//        Member member2 = new Member(memberId2, "정진영",  Grade.VIP);
//        memberService.join(member2);

        Order order = orderService.createOrder(1L, "연필", 2000);
        //Order order2 = orderService.createOrder(4L, "앨범", 12500);

        if(!"F".equals(order.getRst())) {
            System.out.println(order);
            System.out.println("==========");
           // System.out.println(order2);
        }else{
            System.out.println(order.getRstMsg());
        }
    }

}
