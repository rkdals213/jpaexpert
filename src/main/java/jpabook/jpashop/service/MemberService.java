package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.domain.Order;
import jpabook.jpashop.domain.OrderSearch;
import jpabook.jpashop.repository.MemberRepository;
import jpabook.jpashop.repository.OrderRepository2;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final OrderRepository2 repository2;

    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Long join(Member member) {
        return memberRepository.save(member).getId();
    }

    public Member findOne(Long id) {
        return memberRepository.findById(id).get();
    }

    public List<Order> findAll() {
        return repository2.findAll(new OrderSearch());
    }

    @Transactional
    public void update(Long id, String name) {
        Member member = findOne(id);
        member.setName(name);
    }


}
