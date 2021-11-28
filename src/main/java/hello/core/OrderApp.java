package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp  {
    public static void main(String[] args){
        //MemberService memberService = new MemberServiceImpl();
        //OrderService orderService = new OrderServiceImpl();
        // 스프링 컨테이너 생성, 생성시 AppConfig를 구성정보로 지정
        //                                       ApplicationContext 인터페이스 구현체,
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        //AppConfig appConfig = new AppConfig();
        //MemberService memberService = appConfig.memberService();
        //OrderService orderService = appConfig.orderService();
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

        long memberId = 1L;
        Member member = new Member(memberId, "차승연",  Grade.VIP);
        memberService.join(member);
//
//        long memberId2 = 2L;
//        Member member2 = new Member(memberId2, "정진영",  Grade.VIP);
//        memberService.join(member2);

        Order order = orderService.createOrder(1L, "연필", 2000); // 2000 * 10 / 100 = 20000 / 100 = 200
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
