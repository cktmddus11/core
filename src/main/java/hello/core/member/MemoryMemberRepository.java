package hello.core.member;

import java.util.HashMap;
import java.util.Map;

// 자체(메모리) 저장소
public class MemoryMemberRepository implements MemberRepository {
    private static Map<Long, Member> store = new HashMap<>();
    // ** HashMap은 동시성 이슈가 발생할 수 있으므로 ConcurrentHashMap 을 사용하자

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        Member findMember = store.get(memberId);
        if(findMember == null){
            findMember = new Member();
            findMember.setRst("F");
            findMember.setRstMsg("해당 ID로 조회되는 회원이 없습니다. ");
        }
        return findMember;
    }
}
