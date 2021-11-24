package hello.core.member;

public class MemberServiceImpl implements MemberService{
    // 회원서비스가 현제는 메모리 회원 저장소로 되어있지만
    // 추후에 디비로 조회하는 로직이 추가된다면 지금 코드는
    // OCP 원칙을 준수하고 있지 않아 => 의존성 문제

    //private final MemberRepository memberRepository = new MemoryMemberRepository();
    //생성자를 통해 구현체 주입
    private MemberRepository memberRepository;
    // MemberServiceImpl입장에서는 어떤 구현 객체가 들어올지(주입될지)모른다.
    // MeberServiceImpl 의 생성자에 어떤 객체를 주입하는가 => AppConfig에서 설정
    // MemberServiceImpl은 의존관계에 대한 고민은 외부에 맡기고 실행에만 집중하면 됨.
    // ** DIP 완성 : 해당 구현 클래스는 MemberRepository 추상클래스만 의존하면 됨. 구현 클래스 몰라도됨.
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
