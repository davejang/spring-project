package hello.hellospring.repository;
import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    //store initialize
    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("hello");

        repository.save(member);
        Member result = repository.findById(member.getId()).get();
        Assertions.assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("hello1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("hello2");
        repository.save(member2);

        Member result1 = repository.findByName("hello1").get();
        Assertions.assertThat(member1).isEqualTo(result1);

        Member result2 = repository.findByName("hello2").get();
        Assertions.assertThat(member2).isEqualTo(result2);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("hello1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("hello2");
        repository.save(member2);

        List<Member> result = repository.findAll();
        Assertions.assertThat(result.size()).isEqualTo(2);
    }
}
