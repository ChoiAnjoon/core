package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

// springboot를 쓰면 ComponentScan을 쓸필요 없이
// @SpringBootApplication 자동생성된 곳에서 자동으로 컴포넌트 스캔을 해주어서
// 사실 스프링 부트를 쓰면 컴포넌트 스캔을 하지 않아도 된다.
@Configuration
@ComponentScan(
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

    // bean 이름 중복을 알아보기 위한 코드
//    @Bean(name = "memoryMemberRepository")
//    MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//    }
}
