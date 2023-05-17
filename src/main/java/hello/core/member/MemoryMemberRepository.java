package hello.core.member;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component // 빈 컨네이터에 등록되는 이름은 memoryMemberRepository
public class MemoryMemberRepository implements MemberRepository {

    // Map 변수를 static 즉 클래스 변수로 설정하는 이유는 무었일까 --> 해결
    private static Map<Long, Member> store = new HashMap<>();
    // 원래는 동시성 이슈가 발생할 수 있기 때문에 concurrent HashMap을 사용해야한다.

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
