package introduction.introductionSpring.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import introduction.introductionSpring.domain.Member;
import introduction.introductionSpring.repository.MemberRepository;
import introduction.introductionSpring.repository.MemoryMemberRepository;

class MemberServiceTest {
	
	
	
	//MemberService memberService = new MemberService();
	
	//new�� �ٸ� ��ü�� �����ϸ� ���빰�� �޶��� ���� �ִ�.
	//MemoryMemberRepository memberRepository = new MemoryMemberRepository();
	
	MemberService memberService;
	MemoryMemberRepository memberRepository;
	
	//DI Dependency Injection
	@BeforeEach
	public void beforeEach() {
		memberRepository = new MemoryMemberRepository();
		memberService = new MemberService(memberRepository);
	}
	
	
	@AfterEach
	public void afterEach() {
		memberRepository.clearStore();
	}
	
	@Test
	void ȸ������() {
		//given
		Member member = new Member();
		member.setName("spring");
		
		//when
		Long saveId = memberService.join(member);
		
		//then
		Member findMember = memberService.findOne(saveId).get();
		assertThat(member.getName()).isEqualTo(findMember.getName());
	}
	
	@Test
	public void �ߺ�_ȸ��_����() {
		//given
		Member member1 = new Member();
		member1.setName("spring");
		
		Member member2 = new Member();
		member2.setName("spring"); 
		
		//when
		memberService.join(member1);
		IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
		assertThat(e.getMessage()).isEqualTo("�̹� �����Ѵ�");
//		try {
//			memberService.join(member2);
//			fail();
//		} catch(IllegalStateException e) {
//			assertThat(e.getMessage()).isEqualTo("123");
//		}
		
		//then
	}
	
	@Test
	void findMembers() {
		
	}
	
	@Test
	void findOne() {
		
	}
}
